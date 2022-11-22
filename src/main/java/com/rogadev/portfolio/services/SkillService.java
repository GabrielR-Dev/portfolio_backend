
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Skill;
import com.rogadev.portfolio.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkill{
    
    @Autowired
    public SkillRepository skillRepo;

    @Override
    public void publicarSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public Skill verSkill(long id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public List<Skill> verSkills() {
        return (List<Skill>) skillRepo.findAll();
    }

    @Override
    public void eliminarSkill(long id) {
        skillRepo.deleteById(id);
    }
    
}
