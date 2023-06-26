
package com.rogadev.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.rogadev.portfolio.security.model.Usuarios;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
public class SkillDTO implements Serializable {
    
    private Long idSkill;
    
    @NotBlank
    @Size(min = 5, max = 50)
    private String titulo;
    
    @NotBlank
    @Size(min = 5, max = 50)
    private String skillImg;
    
    @NotBlank
    private String porcentaje;

    //private Usuarios usuario;

}
