
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.interfaces.IAcercaDe;
import com.rogadev.portfolio.dto.AcercaDeDTO;
import com.rogadev.portfolio.model.AcercaDe;
import com.rogadev.portfolio.repository.AcercaDeRepository;
import com.rogadev.portfolio.security.model.Usuarios;
import com.rogadev.portfolio.security.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Validated
public class AcercaDeService implements IAcercaDe{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AcercaDeRepository acercaDeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<AcercaDeDTO> crearAcercaDe(AcercaDeDTO acercadeDTO) {


        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        acercadeDTO.setIdAcercaDe(null);

        AcercaDe entity = modelMapper.map(acercadeDTO, AcercaDe.class);
        entity.setUsuario(usuario);
        acercaDeRepository.save(entity);

        AcercaDeDTO dto = modelMapper.map(entity, AcercaDeDTO.class);
        return ResponseEntity.ok().body(dto);
    }





    @Override
    public ResponseEntity<AcercaDeDTO> verAcercaDe()
    {

        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuarios = usuarioRepository.findByUsername(nombre).orElseThrow();
        AcercaDe entity = acercaDeRepository.findByUsuario(usuarios);


        if (entity.getUsuario() != usuarios){
            throw new AccessDeniedException("Usuario no autorizado");
        }

        AcercaDeDTO dto = modelMapper.map(entity, AcercaDeDTO.class);
        return ResponseEntity.ok().body(dto);

    }






    @Override
    public ResponseEntity<AcercaDeDTO> editarAcercaDe(AcercaDeDTO acercadeDTO) {

        AcercaDe acercaDe = acercaDeRepository.findById(acercadeDTO.getIdAcercaDe()).orElseThrow();

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        AcercaDe entity = modelMapper.map(acercadeDTO, AcercaDe.class);
        entity.setUsuario(usuario);


        acercaDeRepository.save(entity);
        AcercaDeDTO dto = modelMapper.map(entity, AcercaDeDTO.class);
        return ResponseEntity.ok().body(dto);
    }
    
}