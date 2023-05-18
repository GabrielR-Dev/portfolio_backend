package com.rogadev.portfolio.security.service;

import com.rogadev.portfolio.security.dto.AuthRespuestaDTO;
import com.rogadev.portfolio.security.dto.LoginDTO;
import com.rogadev.portfolio.security.dto.RegistroDTO;
import com.rogadev.portfolio.security.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserDetailsServiceImpl userDetailsService;


    private String registrarseService (RegistroDTO registroDTO){
        return null;
    }

    public AuthRespuestaDTO iniciarSesionService (LoginDTO loginDTO){

        UserDetails usuarioDetails = userDetailsService.loadUserByUsername(loginDTO.getEmail());

        return null;
    }

    private void cerrarSesion(){

    }

}
