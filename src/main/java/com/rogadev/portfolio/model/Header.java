
package com.rogadev.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "header")
@Getter @Setter
public class Header {
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idHeader;
    
    String portadaImg, frase;

    public Header() {
    }

    public Header(int idHeader, String portadaImg, String frase) {
        this.idHeader = idHeader;
        this.portadaImg = portadaImg;
        this.frase = frase;
    }
    
    
}
