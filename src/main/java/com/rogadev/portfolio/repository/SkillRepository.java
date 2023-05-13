
package com.rogadev.portfolio.repository;

import com.rogadev.portfolio.model.Skill;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository <Skill, Long>{
    public List<Skill> findAll();
}
