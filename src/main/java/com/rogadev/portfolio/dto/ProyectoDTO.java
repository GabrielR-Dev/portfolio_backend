
package com.rogadev.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProyectoDTO {
    
    private long idProyecto;
    
    @NotBlank
    @Size(min = 10, max = 50)
    private String titulo;
    
    @NotBlank
    @Size(min = 10, max = 250)
    private String link;
    
    @NotBlank
    @Size(min = 10, max = 150)
    private String proyectoImg;
    
    @NotBlank
    @Size(min = 10, max = 250)
    private String descripcion;
    
}
