package com.ilovenews.News.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final PasswordEncoder encoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) {
        security
//                .cors(cors -> cors.configurationSource(corsConfiguration()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/news/**").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return security.build();
    }


    @Bean
    public CorsConfigurationSource corsConfiguration() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration
                .setAllowedOrigins(List.of("*"));
        configuration
                .setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONAL", "PATCH"));
        configuration
                .setExposedHeaders(List.of("Authorization"));
        configuration
                .setAllowedHeaders(List.of("Authorization", "title"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        UserDetails userDetails1 = User.withUsername("Om").roles("ADMIN").password(encoder.encode("Om")).build();
        return new InMemoryUserDetailsManager(userDetails1);
    }
}
