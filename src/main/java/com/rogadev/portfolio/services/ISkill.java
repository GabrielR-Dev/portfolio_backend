
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.model.Skill;
import java.util.List;


public interface ISkill {
    
    public void publicarSkill(Skill skill);
    public Skill verSkill(long id);
    public List<Skill> verSkills ();
    public void eliminarSkill (long id);
}
