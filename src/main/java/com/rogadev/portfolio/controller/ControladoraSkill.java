
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.dto.SkillDTO;
import com.rogadev.portfolio.model.Skill;
import com.rogadev.portfolio.services.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
public class ControladoraSkill {
    
    @Autowired
    private SkillService skillServ;
    
    @PostMapping("/post")
    public ResponseEntity<SkillDTO> publicarSkill (@RequestBody SkillDTO skillDTO){
        return skillServ.publicarSkill(skillDTO);
    }
    
    @GetMapping("/ver{id}")
    public ResponseEntity<SkillDTO> verSkill (@RequestParam long id){
        return skillServ.verSkill(id);
    }
    
    @GetMapping("/verskills")
    public ResponseEntity<List<SkillDTO>> verSkills(){
        return skillServ.verSkills();
    }
   
    @DeleteMapping("/eliminarskill{id}")
    public ResponseEntity eliminarSkill(@RequestParam long id){
        return skillServ.eliminarSkill(id);
    }
    
}
