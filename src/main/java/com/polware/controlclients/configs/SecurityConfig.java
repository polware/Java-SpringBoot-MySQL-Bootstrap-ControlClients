package com.polware.controlclients.configs;

import com.polware.controlclients.services.UsuarioDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Created by IntelliJ IDEA
 * User: Paul H. Vargas P.
 * Date: 6/06/2023
 * Time: 9:13 p. m.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UsuarioDetailsService usuarioDetailsService;

    public SecurityConfig(UsuarioDetailsService usuarioDetailsService) {
        this.usuarioDetailsService = usuarioDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .and()
                .authorizeHttpRequests().requestMatchers("/webjars/**").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/", "/page403").hasAnyAuthority("ADMIN", "USER")
                .and()
                .authorizeHttpRequests().requestMatchers("/add/**", "/edit/**", "/save", "/delete").hasAuthority("ADMIN")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        http.authenticationProvider(authenticationProvider());

        return http.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider  = new DaoAuthenticationProvider();
        authProvider .setUserDetailsService(usuarioDetailsService);
        authProvider .setPasswordEncoder(passwordEncoder());
        return authProvider ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
