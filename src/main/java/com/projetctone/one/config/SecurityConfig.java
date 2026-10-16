package com.projetctone.one.config;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.projetctone.one.controllers.JwtAuthenticationFilter;


@Configuration 
@EnableWebSecurity 
public class SecurityConfig {
   @Value ("${api.security.token.secret}")
    private String secretKey;
  
    
    

    @Bean 
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        return http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login", "/listar/{cep}").permitAll()
                .anyRequest().authenticated()
            )
         
            .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class).build();
    }

   
}
