
package com.rogadev.portfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HeaderDTO {
    private long idHeader;
    
    @NotBlank
    @Size(min = 5, max = 50)
    private String portadaImg;
    
    @NotBlank
    @Size(max = 100)
    private String frase;
}
