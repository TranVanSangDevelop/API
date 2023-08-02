package com.alibou.security.config;

import com.alibou.security.auth.CustomExceptionHandler;
import com.alibou.security.auth.InvalidTokenException;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.context.request.WebRequest;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .cors()
            .and()
            .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.ignoringRequestMatchers("/api/v1/**"))
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/auth/**")
            .permitAll()
            .and()
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/**")
            .authenticated()
            .and()
            .authorizeHttpRequests()
            .requestMatchers("/**")
            .permitAll()
            .and()
            .httpBasic()
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(this.jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
