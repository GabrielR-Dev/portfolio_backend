
package com.rogadev.portfolio.interfaces;

import com.rogadev.portfolio.dto.SkillDTO;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;


public interface ISkill {
    
    public ResponseEntity<SkillDTO> publicarSkill(@Valid SkillDTO skillDTO);
    public ResponseEntity<SkillDTO> verSkill(long id);
    public ResponseEntity<List<SkillDTO>> verSkills ();
    public ResponseEntity eliminarSkill (long id);
}
