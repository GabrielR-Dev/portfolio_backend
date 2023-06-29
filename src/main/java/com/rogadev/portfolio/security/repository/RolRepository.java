package com.rogadev.portfolio.security.repository;

import com.rogadev.portfolio.security.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Roles,Long> {

    Optional<Roles> findByName(String nombre);

}
