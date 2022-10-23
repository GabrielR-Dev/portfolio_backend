
package com.rogadev.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proyectos")
@Getter @Setter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idProyecto;
    
    String titulo,link, proyectoImg,descripcion;

    public Proyecto() {
    }

    public Proyecto(long idProyecto, String titulo, String link, String proyectoImg, String descripcion) {
        this.idProyecto = idProyecto;
        this.titulo = titulo;
        this.link = link;
        this.proyectoImg = proyectoImg;
        this.descripcion = descripcion;
    }
    
}
