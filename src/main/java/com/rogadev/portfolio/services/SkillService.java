
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.SkillDTO;
import com.rogadev.portfolio.interfaces.ISkill;
import com.rogadev.portfolio.model.Experiencia;
import com.rogadev.portfolio.model.Skill;
import com.rogadev.portfolio.repository.SkillRepository;
import java.util.List;
import java.util.stream.Collectors;

import com.rogadev.portfolio.security.model.Usuarios;
import com.rogadev.portfolio.security.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.AssociationOverride;
import javax.servlet.http.HttpSession;

@Service
public class SkillService implements ISkill{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SkillRepository skillRepo;
    @Autowired
    private ModelMapper modelMappr;

    @Override
    public ResponseEntity<SkillDTO> publicarSkill(SkillDTO skillDTO) {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();
        skillDTO.setIdSkill(null);

        Skill entity = modelMappr.map(skillDTO, Skill.class);
        entity.setUsuario(usuario);

        skillRepo.save(entity);
        SkillDTO dto = modelMappr.map(entity, SkillDTO.class);
        return ResponseEntity.ok().body(dto);
        
    }

    @Override
    public ResponseEntity<SkillDTO> verSkill(long id) {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();
        Skill entity = skillRepo.findById(id).orElse(null);

        if(entity.getUsuario() != usuario) throw new AccessDeniedException("El usuario no puede acceder a datos que no le corresponden");


        SkillDTO dto = modelMappr.map(entity, SkillDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<SkillDTO>> verSkills() {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        List<Skill> entitys = skillRepo.findByUsuario(usuario);
        List<SkillDTO> dto = entitys.stream().map(skill -> modelMappr.map(skill, SkillDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity eliminarSkill(long id) {

       if(!skillRepo.existsById(id)){
            return (ResponseEntity<HeadersBuilder>) ResponseEntity.noContent();
        }

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();
        Skill entity = skillRepo.findById(id).orElseThrow();

        if (entity.getUsuario() != usuario) throw new AccessDeniedException("No puedes borrar datos de otro usuario");

        skillRepo.deleteById(id);
        return (ResponseEntity<Long>) ResponseEntity.ok().body(id);
    }


}
