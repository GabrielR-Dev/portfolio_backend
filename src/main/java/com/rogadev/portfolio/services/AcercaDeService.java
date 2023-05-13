
package com.rogadev.portfolio.services;

import com.rogadev.portfolio.interfaces.IAcercaDe;
import com.rogadev.portfolio.dto.AcercaDeDTO;
import com.rogadev.portfolio.model.AcercaDe;
import com.rogadev.portfolio.repository.AcercaDeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class AcercaDeService implements IAcercaDe{
    
    @Autowired
    private AcercaDeRepository acercaDeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<AcercaDeDTO> crearAcercaDe(AcercaDeDTO acercadeDTO) {
        
        AcercaDe acercaDe = modelMapper.map(acercadeDTO, AcercaDe.class);
        acercaDeRepository.save(acercaDe);
        AcercaDeDTO dto = modelMapper.map(acercaDe, AcercaDeDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<AcercaDeDTO> verAcercaDe(long id) {
        AcercaDe entity = acercaDeRepository.findById(id).orElse(null);
        AcercaDeDTO dto = modelMapper.map(entity, AcercaDeDTO.class);

        return ResponseEntity.ok().body(dto);
    }

    @Override
    public ResponseEntity<AcercaDeDTO> editarAcercaDe(AcercaDeDTO acercadeDTO) {
        AcercaDe entity = modelMapper.map(acercadeDTO, AcercaDe.class);
        acercaDeRepository.save(entity);
        AcercaDeDTO dto = modelMapper.map(entity, AcercaDeDTO.class);
        
        return ResponseEntity.ok().body(dto);
    }
    
}