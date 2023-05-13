
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.SkillDTO;
import com.rogadev.portfolio.interfaces.ISkill;
import com.rogadev.portfolio.model.Skill;
import com.rogadev.portfolio.repository.SkillRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkill{
    
    @Autowired
    public SkillRepository skillRepo;
    @Autowired
    private ModelMapper modelMappr;

    @Override
    public ResponseEntity<SkillDTO> publicarSkill(SkillDTO skillDTO) {
        Skill entity = modelMappr.map(skillDTO, Skill.class);
        skillRepo.save(entity);
        SkillDTO dto = modelMappr.map(entity, SkillDTO.class);
        return ResponseEntity.ok().body(dto);
        
    }

    @Override
    public ResponseEntity<SkillDTO> verSkill(long id) {
        Skill entity = skillRepo.findById(id).orElse(null);
        SkillDTO dto = modelMappr.map(entity, SkillDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<SkillDTO>> verSkills() {
        List<Skill> entitys = skillRepo.findAll();
        List<SkillDTO> dto = entitys.stream().map(skill -> modelMappr.map(skill, SkillDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity eliminarSkill(long id) {
       if(!skillRepo.existsById(id)){
            return (ResponseEntity<HeadersBuilder>) ResponseEntity.noContent();
        }
        skillRepo.deleteById(id);
        return (ResponseEntity<Long>) ResponseEntity.ok().body(id);
    }


}
