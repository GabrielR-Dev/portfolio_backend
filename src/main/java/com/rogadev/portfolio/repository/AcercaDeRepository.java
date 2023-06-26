
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.AcercaDe;
//import org.springframework.data.jpa.repository.JpaRepository;
import com.rogadev.portfolio.security.model.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcercaDeRepository extends CrudRepository<AcercaDe,Long> {

    AcercaDe findByUsuario(Usuarios usuarios);
        
}
