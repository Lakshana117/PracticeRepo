package com.example.jwtauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Define an in-memory user with username: user and password: pwd
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}pwd") // {noop} means no encoding
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    // Allow /authenticate without login and enable Basic Auth for others
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll() // allow this without login
                .anyRequest().authenticated() // other endpoints require auth
                .and()
                .httpBasic(); // enable Basic Auth (curl -u user:pwd)

        return http.build();
    }
}
