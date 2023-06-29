
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.EducacionDTO;
import com.rogadev.portfolio.interfaces.IEducacion;
import com.rogadev.portfolio.model.Educacion;
import com.rogadev.portfolio.repository.EducacionRepository;
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
public class EducacionService implements IEducacion{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EducacionRepository educacionRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseEntity<EducacionDTO> publicarEducacion(EducacionDTO educacionDTO) {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        educacionDTO.setIdEducacion(null);

        Educacion entity = modelMapper.map(educacionDTO, Educacion.class);
        entity.setUsuario(usuario);
        educacionRepo.save(entity);

        EducacionDTO dto = modelMapper.map(entity, EducacionDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<EducacionDTO> verEducacion(long id) {

        String nombreUsuarioContex = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContex).orElseThrow();
         Educacion entity = educacionRepo.findById(id).orElse(null);

        if (entity.getUsuario() != usuario) throw new AccessDeniedException("Id de la educacion no corresponde al usuario del contexto");

         EducacionDTO dto = modelMapper.map(entity, EducacionDTO.class);
         return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<EducacionDTO>> verEducacion() {

        String nombreUsuarioContex = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContex).orElseThrow();

        List<Educacion> entitys = educacionRepo.findByUsuario(usuario);
        List<EducacionDTO> listDto = entitys.stream().map(educacion -> modelMapper.map(educacion, EducacionDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }


    @Override
    public ResponseEntity<EducacionDTO> editarEducacion(EducacionDTO educacionDTO) {

        String nombreUsuarioContex = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContex).orElseThrow();

        Educacion entity = educacionRepo.findById(educacionDTO.getIdEducacion()).orElseThrow();

        if(entity.getUsuario() != usuario) throw new AccessDeniedException("El usuario no puede editar un elemento que no le corresponde");

        Educacion entity2 = modelMapper.map(educacionDTO, Educacion.class);
        entity2.setUsuario(usuario);
        educacionRepo.save(entity2);
        EducacionDTO dto = modelMapper.map(entity2, EducacionDTO.class);
        return ResponseEntity.ok().body(dto);
        
    }

    @Override
    public ResponseEntity eliminarEducacion(long id) {

        if(!educacionRepo.existsById(id)){
            return (ResponseEntity<HeadersBuilder>) ResponseEntity.noContent();
        }
        String nombreUsuarioContex = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContex).orElseThrow();

        Educacion entity = educacionRepo.findById(id).orElseThrow();

        if (entity.getUsuario() != usuario){
            throw new AccessDeniedException("El usuario no puede eliminar un elemento que no le corresponde");
        }

        educacionRepo.delete(entity);
        return (ResponseEntity<Long>) ResponseEntity.ok().body(id);
    }
}
