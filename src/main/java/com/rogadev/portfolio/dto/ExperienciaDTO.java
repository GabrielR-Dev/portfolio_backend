
package com.rogadev.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rogadev.portfolio.security.model.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ExperienciaDTO implements Serializable {
    
    private Long idExperiencia;
    
    @NotBlank
    @Size(min = 5, max=30)
    private String lugar;
    
    @NotBlank
    @Size(min = 5, max=30)
    private String sector; 
    
    @NotBlank
    @Size(min = 5, max=30)
    private String referencia; 
    
    @NotBlank
    @Size(min = 5, max=50)
    private String logoEmpresaImg;

    @NotBlank
    @Pattern(regexp = "^$|^([0-9]{2}-[0-9]{2}-[0-9]{4})$")
    private String fechaI;
    
    @NotBlank
    @Pattern(regexp = "^$|^([0-9]{2}-[0-9]{2}-[0-9]{4})$")
    private String fechaF;

    //private Usuarios usuario;

}
