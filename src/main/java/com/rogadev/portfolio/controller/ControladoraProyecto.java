
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.model.Proyecto;
import com.rogadev.portfolio.services.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
public class ControladoraProyecto {
    
    @Autowired
    private ProyectoService proyectoServ;
    
      @PostMapping("/post")
    public void publicarProyecto(@RequestBody Proyecto proyecto){
        
    }
    
    @GetMapping("/ver")
    public Proyecto verProyecto (long id){
        return proyectoServ.verProyecto(id);
    }
    
    @GetMapping("/verproyectos")
    public List<Proyecto> verProyectos(){
        return proyectoServ.verProyectos();
    }
   
    @DeleteMapping("/eliminarproyecto")
    public void eliminarProyecto(long id){
        proyectoServ.eliminarProyecto(id);
    }
    
}
