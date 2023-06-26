package com.rogadev.portfolio.security.JWT;

import com.rogadev.portfolio.security.JWT.JwtAuthenticationEntryPoint;
import com.rogadev.portfolio.security.JWT.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .exceptionHandling() //Permitimos el manejo de excepciones
                .authenticationEntryPoint(jwtAuthenticationEntryPoint) //Nos establece un punto de entrada personalizado de autenticación para el manejo de autenticaciones no autorizadas
                .and()
                .sessionManagement() //Permite la gestión de sessiones
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//Politica de sessiones sin estado
                .and()
                .authorizeHttpRequests()//Autorizaciones
                .antMatchers(HttpMethod.POST, "/api/auth/*").permitAll()//todo los metodos POST en la ruta /api/auth/* son permitidas
                .antMatchers(HttpMethod.GET).permitAll()//todos los metodos GET son permitidos
                //.antMatchers(HttpMethod.DELETE).permitAll()
                  //  .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated();//cualquier otra peticion tiene que estar autenticada con el correspondiente JWT
                //.and()
                //.httpBasic();
        http.addFilterAfter(jwtAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class); //inyectamos un filtro de autenticacion para que se ejecute antes de la clase
        return http.build();
    }
}
