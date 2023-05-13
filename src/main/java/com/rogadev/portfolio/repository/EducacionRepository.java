
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.Educacion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends CrudRepository <Educacion, Long> {

    @Override
    public List<Educacion> findAll ();


}
