package com.MyCRM.MyCRM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/api/users/register").permitAll() // Qeydiyyat 
                .requestMatchers("/api/users/login").permitAll() // Giriş
                .requestMatchers("/api/customers").authenticated() // daxil olan istifadəçilərə müştərilərlə bağlı məlumat əldə etmək imkanı verir 
                .anyRequest().denyAll() 
            )
            .oauth2Login(Customizer.withDefaults());  // OAuth2 ilə giriş

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
    



