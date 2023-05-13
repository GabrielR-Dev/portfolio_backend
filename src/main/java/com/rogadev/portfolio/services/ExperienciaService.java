
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.ExperienciaDTO;
import com.rogadev.portfolio.interfaces.IExperiencia;
import com.rogadev.portfolio.model.Experiencia;
import com.rogadev.portfolio.repository.ExperienciaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.type.AnyType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ExperienciaService implements IExperiencia{

    @Autowired
    private ExperienciaRepository expRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    
    @Override
    public ResponseEntity<ExperienciaDTO> publicarExperiencia(ExperienciaDTO expDTO) {
        Experiencia entity = modelMapper.map(expDTO, Experiencia.class);
        expRepo.save(entity);
        ExperienciaDTO dto = modelMapper.map(entity, ExperienciaDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<ExperienciaDTO> editarExperiencia(ExperienciaDTO expDTO) {
        Experiencia entity = modelMapper.map(expDTO, Experiencia.class);
        expRepo.save(entity);
        ExperienciaDTO dto = modelMapper.map(entity, ExperienciaDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<ExperienciaDTO>> verExperiencias() {
        List<Experiencia> entitys = expRepo.findAll();
        List<ExperienciaDTO> dto = entitys.stream().map(experiencia -> modelMapper.map(experiencia, ExperienciaDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<ExperienciaDTO> verExperiencia(long id) {
        Experiencia entity = expRepo.findById(id).orElse(null);
        ExperienciaDTO dto = modelMapper.map(entity, ExperienciaDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity eliminarExpriencia(long id) {

        if(!expRepo.existsById(id)){
            return (ResponseEntity<HeadersBuilder>) ResponseEntity.noContent();
        }
        expRepo.deleteById(id);
        return (ResponseEntity<Long>) ResponseEntity.ok().body(id);
    }
   
    
}
