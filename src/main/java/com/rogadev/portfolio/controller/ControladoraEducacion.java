
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.dto.EducacionDTO;
import com.rogadev.portfolio.model.Educacion;
import com.rogadev.portfolio.services.EducacionService;

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

@RestController
@RequestMapping("/educacion")
public class ControladoraEducacion {
    
    @Autowired
    private EducacionService educacionServis;
    
    @PostMapping("/post")
    public ResponseEntity<EducacionDTO> crearEducacion(@RequestBody EducacionDTO educacionDTO){        
        return educacionServis.publicarEducacion(educacionDTO);

    }
    
    @GetMapping("/ver{id}")
    @ResponseBody
    public ResponseEntity<EducacionDTO> verEducacion(@RequestParam long id){
        return educacionServis.verEducacion(id);
    }
    
    @GetMapping("/listeducacion")
    @ResponseBody
    public ResponseEntity<List<EducacionDTO>> verEducacion(){
        return educacionServis.verEducacion();
    }
    
    @PutMapping("/editar")
    @ResponseBody
    public ResponseEntity<EducacionDTO> editarEducacion(@RequestBody EducacionDTO educacionDTO){
        return educacionServis.editarEducacion(educacionDTO);
    }
    
    
    @DeleteMapping("/eliminar{id}")
    public ResponseEntity eliminarEducacion(@RequestParam long id){
        return educacionServis.eliminarEducacion(id);
        
    }
}
