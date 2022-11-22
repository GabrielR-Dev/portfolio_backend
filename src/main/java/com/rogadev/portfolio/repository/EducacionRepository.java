
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.Educacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends CrudRepository <Educacion, Long> {
    
}
