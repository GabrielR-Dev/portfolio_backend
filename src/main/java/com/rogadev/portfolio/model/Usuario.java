
package com.rogadev.portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter @Setter
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUsuario;
    
    @NotNull
    String nombreUsuario, emailUsuario, contraceñaUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String emailUsuario, String contraceñaUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.contraceñaUsuario = contraceñaUsuario;
    }
    
}
