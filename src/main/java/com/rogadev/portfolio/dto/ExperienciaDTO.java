
package com.rogadev.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienciaDTO {
    
    private long idExperiencia;
    
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
    private String fechaInicio;
    
    @NotBlank
    @Pattern(regexp = "^$|^([0-9]{2}-[0-9]{2}-[0-9]{4})$")
    private String fechaFinalizacion;
    
    
}
