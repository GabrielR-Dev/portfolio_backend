package com.rogadev.portfolio.security.repository;

import com.rogadev.portfolio.security.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    Optional<Usuarios> findByUsername(String username);

    Boolean existsByUsername(String username);

}
