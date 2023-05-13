
package com.rogadev.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class SkillDTO {
    
    private long idSkill;
    
    @NotBlank
    @Size(min = 5, max = 50)
    private String titulo;
    
    @NotBlank
    @Size(min = 5, max = 50)
    private String skillImg;
    
    @NotBlank
    private String porcentaje;
}
