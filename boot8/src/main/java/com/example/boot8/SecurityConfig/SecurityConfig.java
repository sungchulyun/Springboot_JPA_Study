package com.example.boot8.SecurityConfig;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    UsersService usersService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("security config.....................");

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
    }




    @Bean
    public PasswordEncoder passwordEncoder(){

        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }


}
