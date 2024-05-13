package com.bookmymovie.configuration;

import com.bookmymovie.serviceImpl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsServiceImpl userService;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req->req.requestMatchers("/", "api/movies/**", "api/movies/{id}", "api/coming-soon/{id}",
                                        "api/login", "api/signup", "/api/bookings/**","/api/bookings/byUserId/**",
                                        "/api/bookings/byUserId/**","/api/screenings/**","/api/users/byEmail",
                                        "/api/seats/byMovieHall/**","api/seats/createSeats","api/bookedSeats/byScrAndSeat/**",
                                        "/api/bookings/byScreeningId/**","api/bookedSeats/byBookingId/**","/api/users/**",
                                        "/api/users/put")
                                .permitAll()
                                .requestMatchers("/api/movieHalls/**","/api/users","api/movies",
                                        "/api/movies/update").hasAuthority("admin")
                                .anyRequest()
                                .authenticated()
                ).userDetailsService(userService)
                .sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
