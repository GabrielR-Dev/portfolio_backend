
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.EducacionDTO;
import com.rogadev.portfolio.interfaces.IEducacion;
import com.rogadev.portfolio.model.Educacion;
import com.rogadev.portfolio.repository.EducacionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class EducacionService implements IEducacion{

    @Autowired
    public EducacionRepository educacionRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<EducacionDTO> publicarEducacion(EducacionDTO educacionDTO) {
        
        Educacion entity = modelMapper.map(educacionDTO, Educacion.class);
        educacionRepo.save(entity);
        EducacionDTO dto = modelMapper.map(entity, EducacionDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<EducacionDTO> verEducacion(long id) {
        
         Educacion entity = educacionRepo.findById(id).orElse(null);
         EducacionDTO dto = modelMapper.map(entity, EducacionDTO.class);
         return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<EducacionDTO>> verEducacion() {
        List<Educacion> entitys = educacionRepo.findAll();
        List<EducacionDTO> listDto = entitys.stream().map(educacion -> modelMapper.map(educacion, EducacionDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity eliminarEducacion(long id) {
       
        if(!educacionRepo.existsById(id)){
            return (ResponseEntity<HeadersBuilder>) ResponseEntity.noContent();
        }
        educacionRepo.deleteById(id);
        return (ResponseEntity<Long>) ResponseEntity.ok().body(id);
    }

    @Override
    public ResponseEntity<EducacionDTO> editarEducacion(EducacionDTO educacionDTO) {
        Educacion entity = modelMapper.map(educacionDTO, Educacion.class);
        educacionRepo.save(entity);
        EducacionDTO dto = modelMapper.map(entity, EducacionDTO.class);
        return ResponseEntity.ok().body(dto);
        
    }

}
