package com.gps.rest.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Ionatan on 06.01.2016.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**", "/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(
            AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource).usersByUsernameQuery("select email as username,password,true from user where email=?")
                .authoritiesByUsernameQuery("select u.email as username,u.role as ROLE_USER from user u where u.email=?");
    }
}