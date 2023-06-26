
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.ProyectoDTO;
import com.rogadev.portfolio.interfaces.IProyecto;
import com.rogadev.portfolio.model.Experiencia;
import com.rogadev.portfolio.model.Proyecto;
import com.rogadev.portfolio.repository.ProyectoRepository;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@Service
@Validated
public class ProyectoService implements IProyecto{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProyectoRepository proyectoRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<ProyectoDTO> publicarProyecto(ProyectoDTO proyectoDTO) {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        proyectoDTO.setIdProyecto(null);

        Proyecto entity = modelMapper.map(proyectoDTO, Proyecto.class);
        entity.setUsuario(usuario);


        proyectoRepo.save(entity);
        ProyectoDTO dto = modelMapper.map(entity, ProyectoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<ProyectoDTO> verProyecto(long id) {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        Proyecto entity = proyectoRepo.findById(id).orElse(null);

        if(entity.getUsuario() != usuario) throw new AccessDeniedException("El usuario no puede acceder a datos que no le corresponden");

        ProyectoDTO dto = modelMapper.map(entity, ProyectoDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<List<ProyectoDTO>> verProyectos() {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        List<Proyecto> entitys = proyectoRepo.findByUsuario(usuario);
        List<ProyectoDTO> dto = entitys.stream().map(proyecto -> modelMapper.map(proyecto, ProyectoDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok().body(dto);
    
    }

    @Override
    public ResponseEntity<ProyectoDTO> editarProyecto( ProyectoDTO proyectoDTO) {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        Proyecto entity = proyectoRepo.findById(proyectoDTO.getIdProyecto()).orElseThrow();

        if(entity.getUsuario() != usuario) throw new AccessDeniedException("El usuario no puede editar datos que no le corresponden");

        Proyecto entity2 = modelMapper.map(proyectoDTO, Proyecto.class);
        entity2.setUsuario(usuario);
        proyectoRepo.save(entity2);
        ProyectoDTO dto = modelMapper.map(entity2, ProyectoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity eliminarProyecto(long id) {

       if(!proyectoRepo.existsById(id)){
            return (ResponseEntity<HeadersBuilder>) ResponseEntity.noContent();
        }

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();
        Proyecto entity = proyectoRepo.findById(id).orElseThrow();

        if (entity.getUsuario() != usuario) throw new AccessDeniedException("No puedes borrar datos de otro usuario");

        proyectoRepo.deleteById(id);
        return ResponseEntity.ok().body(id);
       
    }

}
