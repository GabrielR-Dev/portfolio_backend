
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.dto.AcercaDeDTO;
import com.rogadev.portfolio.services.AcercaDeService;
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
@RequestMapping("/acercade")
public class ControladoraAcercaDe {
    
    @Autowired
    private AcercaDeService acercaDeService;
    
    @PostMapping("/post")
    @ResponseBody
    public ResponseEntity<AcercaDeDTO> crearAcercaDe(@RequestBody AcercaDeDTO acercadeDTO){
        return acercaDeService.crearAcercaDe(acercadeDTO);
        
    }
    
    @PutMapping("/editar")
    public ResponseEntity<AcercaDeDTO> editarAcercaDe(@RequestBody AcercaDeDTO acercadeDTO){
        return acercaDeService.editarAcercaDe(acercadeDTO);
    }
    
    @GetMapping("/ver{usuarioId}")
    @ResponseBody
    public ResponseEntity<AcercaDeDTO> verAcercaDe (@RequestParam long usuarioId){
        return acercaDeService.verAcercaDe(usuarioId);
    }

    
    
}
