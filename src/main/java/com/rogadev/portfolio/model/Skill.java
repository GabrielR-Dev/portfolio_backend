
package com.rogadev.portfolio.model;

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
@Table(name = "skills")
@Getter @Setter
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSkill;
    
    private String titulo, skillImg, porcentaje;
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/

    public Skill() {
    }

    public Skill(String titulo, String skillImg, String porcentaje) {
        this.titulo = titulo;
        this.skillImg = skillImg;
        this.porcentaje = porcentaje;
    }
    
    
    
}
