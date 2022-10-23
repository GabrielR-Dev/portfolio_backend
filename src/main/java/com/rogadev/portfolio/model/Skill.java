
package com.rogadev.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter @Setter
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idSkill;
    
    String titulo, skillImg, porcentaje;

    public Skill() {
    }

    public Skill(long idSkill, String titulo, String skillImg, String porcentaje) {
        this.idSkill = idSkill;
        this.titulo = titulo;
        this.skillImg = skillImg;
        this.porcentaje = porcentaje;
    }
    
    
    
}
