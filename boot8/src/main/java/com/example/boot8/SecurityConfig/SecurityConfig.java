package com.example.boot8.SecurityConfig;


import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity http)throws Exception{

        log.info("security config.....................");

        http.authorizeRequests().antMatchers("/guest/**").permitAll();

        http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return null;
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return false;
            }
        };
    }
}
