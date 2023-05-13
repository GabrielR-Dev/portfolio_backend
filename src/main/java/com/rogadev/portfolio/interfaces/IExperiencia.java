
package com.rogadev.portfolio.interfaces;

import com.rogadev.portfolio.dto.ExperienciaDTO;
import com.rogadev.portfolio.model.Experiencia;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.type.AnyType;
import org.springframework.http.ResponseEntity;


public interface IExperiencia {
    
    public ResponseEntity<ExperienciaDTO> publicarExperiencia (@Valid ExperienciaDTO expDTO);
    public ResponseEntity<ExperienciaDTO> editarExperiencia(@Valid ExperienciaDTO expDTO);
    public ResponseEntity<List<ExperienciaDTO>> verExperiencias();
    public ResponseEntity<ExperienciaDTO> verExperiencia (long id);
    public ResponseEntity eliminarExpriencia (long id);
    
}
