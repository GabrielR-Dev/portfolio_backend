
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.dto.HeaderDTO;
import com.rogadev.portfolio.interfaces.IHeader;
import com.rogadev.portfolio.model.Header;
import com.rogadev.portfolio.repository.HeaderRepository;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HeaderService implements IHeader{
    
    @Autowired
    public HeaderRepository headerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<HeaderDTO> crearHeader(HeaderDTO headerDTO) {
        Header entity = modelMapper.map(headerDTO, Header.class);
        headerRepo.save(entity);
        HeaderDTO dto = modelMapper.map(entity, HeaderDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<HeaderDTO> verHeader(long id) {
        Header entity = headerRepo.findById(id).orElse(null);
        HeaderDTO dto = modelMapper.map(entity, HeaderDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<HeaderDTO> editarHeader(HeaderDTO headerDTO) {
        Header entity = modelMapper.map(headerDTO, Header.class);
        headerRepo.save(entity);
        HeaderDTO dto = modelMapper.map(entity, HeaderDTO.class);
        return ResponseEntity.ok().body(dto);

    }


    
}
