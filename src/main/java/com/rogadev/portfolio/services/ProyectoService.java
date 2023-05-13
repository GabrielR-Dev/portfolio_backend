
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.ProyectoDTO;
import com.rogadev.portfolio.interfaces.IProyecto;
import com.rogadev.portfolio.model.Proyecto;
import com.rogadev.portfolio.repository.ProyectoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Validated
public class ProyectoService implements IProyecto{

    @Autowired
    public ProyectoRepository proyectoRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<ProyectoDTO> publicarProyecto(ProyectoDTO proyectoDTO) {
        Proyecto entity = modelMapper.map(proyectoDTO, Proyecto.class);
        proyectoRepo.save(entity);
        ProyectoDTO dto = modelMapper.map(entity, ProyectoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<ProyectoDTO> verProyecto(long id) {
        Proyecto entity = proyectoRepo.findById(id).orElse(null);
        ProyectoDTO dto = modelMapper.map(entity, ProyectoDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<ProyectoDTO>> verProyectos() {
        List<Proyecto> entitys = proyectoRepo.findAll();
        List<ProyectoDTO> dto = entitys.stream().map(proyecto -> modelMapper.map(proyecto, ProyectoDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok().body(dto);
    
    }

    @Override
    public ResponseEntity eliminarProyecto(long id) {
       
       if(!proyectoRepo.existsById(id)){
            return (ResponseEntity<HeadersBuilder>) ResponseEntity.noContent();
        }
        proyectoRepo.deleteById(id);
        return (ResponseEntity<Long>) ResponseEntity.ok().body(id);
       
    }

    @Override
    public ResponseEntity<ProyectoDTO> editarProyecto( ProyectoDTO proyectoDTO) {
        Proyecto entity = modelMapper.map(proyectoDTO, Proyecto.class);
        proyectoRepo.save(entity);
        ProyectoDTO dto = modelMapper.map(entity, ProyectoDTO.class);
        return ResponseEntity.ok(dto);
    }

    
}
