
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.model.Experiencia;
import com.rogadev.portfolio.services.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
public class ControladoraExperiencia {
    
    @Autowired
    private ExperienciaService expService;
    
    @PostMapping("/post")
    public void publicarExperiencia (@RequestBody Experiencia exp){
        expService.publicarExperiencia(exp);
    }
    
    @GetMapping("/ver")
    public Experiencia verExperiencia (long id){
        return expService.verExperiencia(id);
    }
    
    @GetMapping("/verexperiencias")
    public List<Experiencia> verExperiencias(){
        return expService.verExperiencias();
    }
   
    @DeleteMapping("/eliminarexperiencia")
    public void eliminarExperiencia(long id){
        expService.eliminarExpriencia(id);
    }
}
