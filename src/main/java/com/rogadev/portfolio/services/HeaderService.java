
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.HeaderDTO;
import com.rogadev.portfolio.interfaces.IHeader;
import com.rogadev.portfolio.model.Header;
import com.rogadev.portfolio.repository.HeaderRepository;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

import com.rogadev.portfolio.security.model.Usuarios;
import com.rogadev.portfolio.security.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class HeaderService implements IHeader{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private HeaderRepository headerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<HeaderDTO> crearHeader(HeaderDTO headerDTO) {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        headerDTO.setIdHeader(null);

        Header entity = modelMapper.map(headerDTO, Header.class);
        entity.setUsuario(usuario);

        headerRepo.save(entity);
        HeaderDTO dto = modelMapper.map(entity, HeaderDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<HeaderDTO> verHeader() throws AccessDeniedException {

        String nombre = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombre).orElseThrow();
        Header entity = headerRepo.findByUsuario(usuario).orElseThrow();


        if(usuario.getIdUsuario() != entity.getIdHeader()){
            throw new AccessDeniedException("Usuario no autorizadoo");
        }

        HeaderDTO dto = modelMapper.map(entity, HeaderDTO.class);
        return ResponseEntity.ok().body(dto);

    }

    @Override
    public ResponseEntity<HeaderDTO> editarHeader(HeaderDTO headerDTO) throws AccessDeniedException {

        String nombreUsuarioContext = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuarios usuario = usuarioRepository.findByUsername(nombreUsuarioContext).orElseThrow();

        if(usuario.getIdUsuario() != headerDTO.getIdHeader()){
            throw new AccessDeniedException("Usuario no autorizadoo");
        }
        Header entity = modelMapper.map(headerDTO, Header.class);
        entity.setUsuario(usuario);
        headerRepo.save(entity);

        HeaderDTO dto = modelMapper.map(entity, HeaderDTO.class);
        return ResponseEntity.ok().body(dto);

    }


    
}
