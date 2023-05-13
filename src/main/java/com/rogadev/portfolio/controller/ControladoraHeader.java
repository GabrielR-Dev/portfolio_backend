
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.dto.HeaderDTO;
import com.rogadev.portfolio.model.Header;
import com.rogadev.portfolio.services.HeaderService;
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

@RestController
@RequestMapping("/header")
public class ControladoraHeader {
    
    @Autowired
    private HeaderService headerService;
    
    @PostMapping("/post")
    public ResponseEntity<HeaderDTO> cearHeader(@RequestBody HeaderDTO headerDTO){
        return headerService.crearHeader(headerDTO);
    }
    
    @GetMapping("/ver{id}")
    @ResponseBody
    public ResponseEntity<HeaderDTO> verHeader(@RequestParam long id){
        return headerService.verHeader(id);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<HeaderDTO> editarHeader(@RequestBody HeaderDTO headerDTO){
        return headerService.editarHeader(headerDTO);
    } 
    
}
