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
                .requestMatchers("/api/users/register").permitAll() // Qeydiyyat marşrutu icazə verilsin
                .requestMatchers("/api/users/login").permitAll() // Giriş marşrutu icazə verilsin
                .requestMatchers("/api/customers").authenticated() // Müştəri marşrutu yalnız daxil olan istifadəçilərə
                .anyRequest().denyAll() // Başqa bütün marşrutlara giriş qadağandır
            )
            .oauth2Login(Customizer.withDefaults());  // OAuth2 ilə giriş

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
    



