
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.ExperienciaDTO;
import com.rogadev.portfolio.interfaces.IExperiencia;
import com.rogadev.portfolio.model.Experiencia;
import com.rogadev.portfolio.repository.ExperienciaRepository;
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
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
public class ExperienciaService implements IExperiencia{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ExperienciaRepository expRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    
    @Override
    public ResponseEntity<ExperienciaDTO> publicarExperiencia(ExperienciaDTO expDTO) {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        expDTO.setIdExperiencia(null);

        Experiencia entity = modelMapper.map(expDTO, Experiencia.class);
        entity.setUsuario(usuario);
        expRepo.save(entity);

        ExperienciaDTO dto = modelMapper.map(entity, ExperienciaDTO.class);
        return ResponseEntity.ok().body(dto);
    }


    @Override
    public ResponseEntity<List<ExperienciaDTO>> verExperiencias(){

        String nombreUsuarioContex = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContex).orElseThrow();


        List<Experiencia> entitys = expRepo.findByUsuario(usuario);
        List<ExperienciaDTO> dto = entitys.stream().map(experiencia -> modelMapper.map(experiencia, ExperienciaDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<ExperienciaDTO> verExperiencia(long id) {

        String nombreUsuarioContex = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContex).orElseThrow();
        Experiencia entity = expRepo.findById(id).orElse(null);

        if(entity.getUsuario() != usuario) throw new AccessDeniedException("El usuario no puede acceder a datos que no le corresponden");

        ExperienciaDTO dto = modelMapper.map(entity, ExperienciaDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<ExperienciaDTO> editarExperiencia(ExperienciaDTO expDTO) {

        String nombreUsuarioContex = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContex).orElseThrow();

        Experiencia entity = expRepo.findById(expDTO.getIdExperiencia()).orElseThrow();

        if(entity.getUsuario() != usuario) throw new AccessDeniedException("El usuario no puede editar datos que no le corresponden");

        Experiencia entity2 = modelMapper.map(expDTO, Experiencia.class);
        entity2.setUsuario(usuario);
        expRepo.save(entity2);
        ExperienciaDTO dto = modelMapper.map(entity2, ExperienciaDTO.class);
        return ResponseEntity.ok().body(dto);
    }


    @Override
    public ResponseEntity eliminarExpriencia(long id) {

        if(!expRepo.existsById(id)){
            return (ResponseEntity<HeadersBuilder>) ResponseEntity.noContent();
        }

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();
        Experiencia entity = expRepo.findById(id).orElseThrow();

        if (entity.getUsuario() != usuario) throw new AccessDeniedException("No puedes borrar datos de otro usuario");

        expRepo.delete(entity);
        return (ResponseEntity<Long>) ResponseEntity.ok().body(id);
    }
   
    
}
