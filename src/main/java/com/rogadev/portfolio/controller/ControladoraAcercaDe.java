
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.dto.AcercaDeDTO;
import com.rogadev.portfolio.security.model.Usuarios;
import com.rogadev.portfolio.services.AcercaDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/usuario/acercade")
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

    @GetMapping("/ver")
    public ResponseEntity<AcercaDeDTO> verAcercaDe (){
        return acercaDeService.verAcercaDe();
    }
    
    
}
