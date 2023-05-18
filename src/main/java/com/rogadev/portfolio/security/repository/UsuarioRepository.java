package com.rogadev.portfolio.security.repository;

import com.rogadev.portfolio.security.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findOneByEmail(String email);

    Boolean existsByEmail(String email);
}
