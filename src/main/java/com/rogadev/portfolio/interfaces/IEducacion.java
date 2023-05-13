
package com.rogadev.portfolio.interfaces;

import com.rogadev.portfolio.dto.EducacionDTO;
import com.rogadev.portfolio.model.Educacion;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface IEducacion {
    
    public ResponseEntity<EducacionDTO> publicarEducacion(@Valid EducacionDTO educacionDTO);
    public ResponseEntity<EducacionDTO> verEducacion(long id);
    public ResponseEntity<List<EducacionDTO>> verEducacion ();
    public ResponseEntity<EducacionDTO> editarEducacion(@Valid EducacionDTO educacionDTO);
    public ResponseEntity eliminarEducacion (long id);
    
}
