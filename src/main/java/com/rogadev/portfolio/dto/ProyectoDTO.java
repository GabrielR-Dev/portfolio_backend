
package com.rogadev.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.rogadev.portfolio.security.model.Usuarios;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProyectoDTO implements Serializable {
    
    private Long idProyecto;
    
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

    //private Usuarios usuario;

}
