
package com.rogadev.portfolio.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rogadev.portfolio.security.model.Usuarios;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducacionDTO implements Serializable {
    
    private Long idEducacion;
    
    @NotBlank
    @Size(min = 5, max= 30)
    private String estudio;
    @NotBlank
    @Size(min = 5, max= 50)
    private String logoImg; 
    
    @Size(min = 5, max= 30)
    private String titulo;
    
    @NotBlank
    @Pattern(regexp = "^$|^([0-9]{2}-[0-9]{2}-[0-9]{4})$")
    private String fechaI;
    
    @NotBlank
    @Pattern(regexp = "^$|^([0-9]{2}-[0-9]{2}-[0-9]{4})$")
    private String fechaF;

    //private Usuarios usuario;
    
}
