package com.rogadev.portfolio.security.service;

import com.rogadev.portfolio.security.dto.DtoAuthRespuesta;
import com.rogadev.portfolio.security.dto.DtoLogin;
import com.rogadev.portfolio.security.dto.DtoRegistro;
import com.rogadev.portfolio.security.model.Roles;
import com.rogadev.portfolio.security.model.Usuarios;
import com.rogadev.portfolio.security.repository.RolRepository;
import com.rogadev.portfolio.security.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthService {

    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private RolRepository rolRepository;
    private UsuarioRepository usuarioRepository;


    public String registrarseService (DtoRegistro registroDTO){
        if (usuarioRepository.existsByUsername(registroDTO.getUsername())) {
            return "El usuario ya existe, intenta con otro";
        }
        Usuarios usuarios = new Usuarios();
        usuarios.setUsername(registroDTO.getUsername());
        usuarios.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
        Roles roles = rolRepository.findByName("USER").get();
        usuarioRepository.save(usuarios);
        return "Registro de usuario exitoso";
    }

    public DtoAuthRespuesta iniciarSesionService (DtoLogin loginDTO){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return null;
    }

    private void cerrarSesion(){

    }

}
