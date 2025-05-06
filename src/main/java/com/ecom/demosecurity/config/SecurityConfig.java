package com.ecom.demosecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                    .requestMatchers("/register", "/login").permitAll() // Public endpoints
                    .anyRequest().authenticated()) // All requests require authentication by default
                // .antMatchers("register", "login").permitAll() // Public endpoints
                // .antMatchers("/api/private/**").authenticated() // Private endpoints
                .httpBasic(Customizer.withDefaults()) // Basic authentication
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session managemen
                .build();
    }        


    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12)); // No password encoding for simplicity
        authProvider.setUserDetailsService(userDetailsService); // Use the custom user details service

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // Used for in-memory authentication with hardcoded users
    // @Bean
    // public UserDetailsService userDetailsService() {

    //     UserDetails user1 = User
    //             .withDefaultPasswordEncoder()
    //             .username("arkkam")
    //             .password("ark")
    //             .roles("USER")
    //             .build();
    //     UserDetails user2 = User
    //             .withDefaultPasswordEncoder()
    //             .username("mohamed")
    //             .password("moh")
    //             .roles("ADMIN")
    //             .build();

    //     return new InMemoryUserDetailsManager(user1, user2);
    // }
}