
package com.rogadev.portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.Column;
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
    
    @Column(nullable = false, length = 50)
    private String portadaImg;
    
    @Column(nullable = false, length = 100)
    private String frase;
    
    /*@OneToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/
    

    public Header() {
    }

    public Header(String portadaImg, String frase) {
        this.portadaImg = portadaImg;
        this.frase = frase;
    }
        public Header(long idHeader, String portadaImg, String frase) {
        this.idHeader = idHeader;
        this.portadaImg = portadaImg;
        this.frase = frase;
    }
    
    
}
