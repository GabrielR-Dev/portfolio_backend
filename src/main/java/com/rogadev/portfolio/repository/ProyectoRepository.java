
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends CrudRepository <Proyecto, Long>{
    
}