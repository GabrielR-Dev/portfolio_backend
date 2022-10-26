
package com.rogadev.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "header")
@Getter @Setter
public class Header {
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHeader;
    
    private String portadaImg, frase;
    
    @OneToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    

    public Header() {
    }

    public Header(String portadaImg, String frase) {
        this.portadaImg = portadaImg;
        this.frase = frase;
    }
    
    
}
