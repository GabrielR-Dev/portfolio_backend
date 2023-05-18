package com.rogadev.portfolio.security.service;

import com.rogadev.portfolio.security.model.Usuario;
import com.rogadev.portfolio.security.repository.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UsuarioRepository usuarioRepository;


    Authentication authentication;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findOneByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException("Usuario no registrado")
        );
        return null;

    }
}
