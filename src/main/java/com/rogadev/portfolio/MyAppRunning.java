package com.rogadev.portfolio;

import com.rogadev.portfolio.security.model.Roles;
import com.rogadev.portfolio.security.model.Usuarios;
import com.rogadev.portfolio.security.repository.RolRepository;
import com.rogadev.portfolio.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class MyAppRunning implements ApplicationRunner{

    @Autowired
    private RolRepository rolesRepository;
    @Autowired
    private UsuarioRepository usuariosRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String rolUser = "USER";
        String rolAdmin = "ADMIN";


        if (!rolesRepository.existsByName(rolUser)) {
            Roles rol = new Roles((long) 1, rolUser);
            rolesRepository.save(rol);
        }
        if (!rolesRepository.existsByName(rolAdmin)) {
            Roles rol = new Roles((long) 2, rolAdmin);
            rolesRepository.save(rol);
        }
        if (!usuariosRepository.existsByUsername("gabrielomarrolon1996@gmail.com")) {

            if (rolesRepository.existsByName("USER")) {

                Usuarios usuarios = new Usuarios();
                usuarios.setUsername("gabrielomarrolon1996@gmail.com");
                usuarios.setPassword(passwordEncoder.encode("Rogadev12"));
                Roles roles = rolesRepository.findByName("USER").get();
                usuarios.getRoles().add(roles);
                usuariosRepository.save(usuarios);
            }
        }
    }
}
