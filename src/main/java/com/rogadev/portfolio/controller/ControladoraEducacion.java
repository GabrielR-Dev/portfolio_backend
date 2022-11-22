
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.model.Educacion;
import com.rogadev.portfolio.services.EducacionService;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public void crearEducacion(@RequestBody Educacion educacion){
        educacionServis.publicarEducacion(educacion);
    }
    
    @GetMapping("/ver")
    @ResponseBody
    public Educacion verEducacion(@RequestParam long id){
        return educacionServis.verEducacion(id);
    }
    
    @GetMapping("/listeducacion")
    @ResponseBody
    public List<Educacion> verEstudios(){
        return educacionServis.verEstudios();
    }
    
    @DeleteMapping("/eliminar")
    public void eliminarEducacion(@RequestParam long id){
        educacionServis.eliminarEducacion(id);
    }
}
