
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.Skill;
import java.util.List;

import com.rogadev.portfolio.security.model.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository <Skill, Long>{
    public List<Skill> findAll();

    public List<Skill> findByUsuario (Usuarios usuario);

}
