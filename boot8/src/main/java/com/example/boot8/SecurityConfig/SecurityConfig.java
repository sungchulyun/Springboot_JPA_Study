package com.example.boot8.SecurityConfig;


import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Log
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    UsersService usersService;

    @Autowired
    DataSource dataSource;

    private PersistentTokenRepository getJDBCRepository(){

        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("security config.....................");

        http.rememberMe().key("user").userDetailsService(usersService).tokenRepository(getJDBCRepository()).tokenValiditySeconds(60*60*24);

        http
                .authorizeRequests()
                .antMatchers("/guest/**").permitAll();

        http
                .authorizeRequests()
                .antMatchers("/manager/**").hasRole("MANAGER");

        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN");

        //로그인 페이지
        http.formLogin().loginPage("/login");

        http.exceptionHandling().accessDeniedPage("/accessDenied");

        http.logout().logoutUrl("/logout").invalidateHttpSession(true);

        http.userDetailsService(usersService);

        http.rememberMe().key("user").userDetailsService(usersService);
    }




    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        log.info("build Auth global");

        auth.userDetailsService(usersService).passwordEncoder(passwordEncoder());

    }


}
