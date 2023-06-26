
package com.rogadev.portfolio.interfaces;

import com.rogadev.portfolio.dto.ProyectoDTO;
import com.rogadev.portfolio.model.Proyecto;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;


public interface IProyecto {
    
    public  ResponseEntity<ProyectoDTO> publicarProyecto(@Valid ProyectoDTO proyectoDTO);
    public  ResponseEntity<ProyectoDTO> editarProyecto(@Valid ProyectoDTO proyectoDTO);
    public ResponseEntity<ProyectoDTO> verProyecto(long id);
    public ResponseEntity<List<ProyectoDTO>> verProyectos ();
    public ResponseEntity eliminarProyecto (long id);
}
