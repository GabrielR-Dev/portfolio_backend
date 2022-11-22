
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.model.AcercaDe;
import com.rogadev.portfolio.services.AcercaDeService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    //@Autowired
    //private ControladoraLogin usu;
    
    @PostMapping("/post")
    public void crearAcercaDe(@RequestBody AcercaDe acercade){
        acercaDeService.crearAcercaDe(acercade);
    }
    
    @PostMapping("/editar")
    public void editarAcercaDe(@RequestBody AcercaDe acercade){
        acercaDeService.editarAcercaDe(acercade);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public Optional<AcercaDe> verAcercaDe (@RequestParam long usuarioId){
        return acercaDeService.verAcercaDe(usuarioId);
    }
    
    
}
