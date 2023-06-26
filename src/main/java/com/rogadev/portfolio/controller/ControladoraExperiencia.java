
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.dto.ExperienciaDTO;
import com.rogadev.portfolio.model.Experiencia;
import com.rogadev.portfolio.services.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/usuario/experiencia")
public class ControladoraExperiencia {
    
    @Autowired
    private ExperienciaService expService;
    
    @PostMapping("/post")
    public ResponseEntity<ExperienciaDTO> publicarExperiencia (@RequestBody ExperienciaDTO expDTO){
        return expService.publicarExperiencia(expDTO);
    }
    
    @GetMapping("/ver{id}")
    @ResponseBody
    public ResponseEntity<ExperienciaDTO> verExperiencia (@RequestParam long id){
        return expService.verExperiencia(id);
    }
    
    @GetMapping("/verexperiencias")
    @ResponseBody
    public ResponseEntity<List<ExperienciaDTO>> verExperiencias(){
        return expService.verExperiencias();
    }
   
    @DeleteMapping("/eliminarexperiencia{id}")
    public ResponseEntity eliminarExperiencia(@RequestParam long id){
        return expService.eliminarExpriencia(id);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<ExperienciaDTO> editarExperiencia (@RequestBody ExperienciaDTO expDTO){
        return expService.editarExperiencia(expDTO);
    }
}