package com.ktech.a2zschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        Custom security requests inside the Web Application
                http
//                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
//                        .requestMatchers("/courses").authenticated()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/holidays/**").permitAll())

                .formLogin(withDefaults())
                .httpBasic(withDefaults());

//      Deny all requests inside the Web Application
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll())
//                .formLogin(withDefaults())
//                .httpBasic(withDefaults());
        return http.build();
    }
}
