
package com.rogadev.portfolio.configuration;

import com.rogadev.portfolio.security.JWT.JwtGenerador;
import com.rogadev.portfolio.security.model.Usuarios;
import com.rogadev.portfolio.security.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class UtilsApp {

    @Bean
    public ModelMapper modelMapper(){
        
        return new ModelMapper();
        
    }
}
