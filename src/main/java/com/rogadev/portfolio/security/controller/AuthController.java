package com.rogadev.portfolio.security.controller;

import com.rogadev.portfolio.security.dto.AuthRespuestaDTO;
import com.rogadev.portfolio.security.dto.LoginDTO;
import com.rogadev.portfolio.security.dto.RegistroDTO;
import com.rogadev.portfolio.security.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/api/auth")
public class AuthController implements Serializable {
    private AuthService authService;

    @PostMapping("registrarse")
    public ResponseEntity<String> registrarse (@RequestBody RegistroDTO registroDTO){



        return null;
    }

    @PostMapping("iniciar-sesion")
    public ResponseEntity<AuthRespuestaDTO> iniciarSesion(@RequestBody LoginDTO loginDTO){


        return null;

    }
    @PostMapping("cerrar-sesion")
    public void cerrarSesion(){

    }



}
