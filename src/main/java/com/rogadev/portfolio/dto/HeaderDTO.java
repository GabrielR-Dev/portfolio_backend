
package com.rogadev.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.rogadev.portfolio.security.model.Usuarios;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class HeaderDTO implements Serializable {
    private Long idHeader;
    
    @NotBlank
    @Size(min = 5, max = 50)
    private String portadaImg;
    
    @NotBlank
    @Size(max = 100)
    private String frase;


}
