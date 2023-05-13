
package com.rogadev.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proyectos")
@Getter @Setter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProyecto;
    
    @Column(nullable = false, length = 30)
    private String titulo;
    
    @Column(nullable = false, length = 250)
    private String link;
    
    @Column(nullable = false, length = 250)
    private String proyectoImg;
    
    @Column(nullable = false, length = 250)
    private String descripcion;
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/
    

    public Proyecto() {
    }

    public Proyecto(String titulo, String link, String proyectoImg, String descripcion) {
        this.titulo = titulo;
        this.link = link;
        this.proyectoImg = proyectoImg;
        this.descripcion = descripcion;
    }
    
}
