
package com.rogadev.portfolio.controller;

import com.rogadev.portfolio.dto.ProyectoDTO;
import com.rogadev.portfolio.services.ProyectoService;
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
@RequestMapping("/usuario/proyecto")
public class ControladoraProyecto {
    
    @Autowired
    private ProyectoService proyecServis;
    
    @PostMapping("/post")
    public ResponseEntity<ProyectoDTO> publicarProyecto (@RequestBody ProyectoDTO proyectoDTO){
        return proyecServis.publicarProyecto(proyectoDTO);
    }
    
    @PutMapping("/editar")
    public ResponseEntity<ProyectoDTO> editarProyecto (@RequestBody ProyectoDTO proyectoDTO){
        return proyecServis.editarProyecto(proyectoDTO);
    }
    
    @GetMapping("/ver{id}")
    @ResponseBody
    public ResponseEntity<ProyectoDTO> verProyecto (@RequestParam long id){
        return proyecServis.verProyecto(id);
    }
    
    @GetMapping("/verproyectos")
    @ResponseBody
    public ResponseEntity<List<ProyectoDTO>> verProyectos (){
        return proyecServis.verProyectos();
    }
    
    @DeleteMapping("/eliminarproyecto{id}")
    public ResponseEntity eliminarProyecto (@RequestParam long id){
        return proyecServis.eliminarProyecto(id);
    }
    
    
}
