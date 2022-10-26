
package com.rogadev.portfolio.model;

import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter @Setter
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    
    @NotNull
    private String nombreUsuario, emailUsuario, contraceñaUsuario;
    
    
    //Relaciones entre tablas OneToOne
    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL)
    private AcercaDe acercaDe;
    
    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL)
    private Header header;
    
    //Relaciones entre tablas OneToMany y ManyToOne
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Experiencia> experiencias;
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Educacion> educacion;
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Proyecto> proyecto;
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Skill> skill;
    
    
    public Usuario() {
    }

    public Usuario(String nombreUsuario, String emailUsuario, String contraceñaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.contraceñaUsuario = contraceñaUsuario;
    }
    
}
