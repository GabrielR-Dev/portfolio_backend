
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.Proyecto;
import java.util.List;

import com.rogadev.portfolio.security.model.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends CrudRepository <Proyecto, Long>{
    public List findAll();

    public List<Proyecto> findByUsuario (Usuarios usuario);

    @Query("DELETE FROM Proyecto p WHERE p.idProyecto = :id")
    public void eliminar (@Param("id") long id);

}