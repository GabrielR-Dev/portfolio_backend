
package com.rogadev.portfolio.interfaces;

import com.rogadev.portfolio.dto.HeaderDTO;
import com.rogadev.portfolio.model.Header;

import java.nio.file.AccessDeniedException;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;


public interface IHeader {
    
    public ResponseEntity<HeaderDTO> crearHeader(@Valid HeaderDTO headerDTO);
    public ResponseEntity<HeaderDTO> verHeader() throws AccessDeniedException;
    public ResponseEntity<HeaderDTO> editarHeader (@Valid HeaderDTO headerDTO) throws AccessDeniedException;
    
}
