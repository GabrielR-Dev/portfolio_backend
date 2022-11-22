
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.model.Skill;
import com.rogadev.portfolio.services.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
public class ControladoraSkill {
    
    @Autowired
    private SkillService skillServ;
    
    @PostMapping("/post")
    public void publicarSkill (@RequestBody Skill skill){
        skillServ.publicarSkill(skill);
    }
    
    @GetMapping("/ver")
    public Skill verSkill (long id){
        return skillServ.verSkill(id);
    }
    
    @GetMapping("/verskills")
    public List<Skill> verSkills(){
        return skillServ.verSkills();
    }
   
    @DeleteMapping("/eliminarskill")
    public void eliminarSkill(long id){
        skillServ.eliminarSkill(id);
    }
    
}
