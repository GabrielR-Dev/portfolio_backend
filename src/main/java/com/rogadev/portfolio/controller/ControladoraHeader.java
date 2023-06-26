
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.dto.HeaderDTO;
import com.rogadev.portfolio.model.Header;
import com.rogadev.portfolio.services.HeaderService;

import java.nio.file.AccessDeniedException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/usuario/header")
public class ControladoraHeader {
    
    @Autowired
    private HeaderService headerService;
    
    @PostMapping("/post")
    public ResponseEntity<HeaderDTO> cearHeader(@RequestBody HeaderDTO headerDTO){
        return headerService.crearHeader(headerDTO);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public ResponseEntity<HeaderDTO> verHeader() throws AccessDeniedException {
        return headerService.verHeader();
    }
    
    @PutMapping("/editar")
    public ResponseEntity<HeaderDTO> editarHeader(@RequestBody HeaderDTO headerDTO) throws AccessDeniedException {
        return headerService.editarHeader(headerDTO);
    } 
    
}
