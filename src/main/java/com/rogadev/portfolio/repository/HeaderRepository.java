
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.Header;
import com.rogadev.portfolio.security.model.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeaderRepository extends CrudRepository <Header, Long>{
    Optional<Header> findByUsuario(Usuarios usuario);
}
