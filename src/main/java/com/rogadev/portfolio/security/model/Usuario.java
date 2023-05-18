package com.rogadev.portfolio.security.model;

import com.rogadev.portfolio.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuarioo;

    private String email;
    private String password;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "idUsuario") //mappedBy ace referencia al nombre de la propiedad de la tabla asociada
    private AcercaDe idAcercaDe;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "idUsuario")
    private Header idHeader;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUsuario")
    private Set<Educacion> idEducacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUsuario")
    private Set<Experiencia> idExperiencia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUsuario")
    private Set<Proyecto> idProyecto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUsuario")
    private Set<Skill> idSkill;


}
