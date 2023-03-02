//package com.example.book.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET, "/books/**").hasRole("USER")
//                .requestMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.PATCH, "/books/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")
//                .and()
//                .httpBasic()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        return http.build();
//    }
//
//}
