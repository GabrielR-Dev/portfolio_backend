
package com.rogadev.portfolio.model;

import com.rogadev.portfolio.security.model.Usuario;
import com.sun.istack.NotNull;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor @NoArgsConstructor
public class Header {
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHeader;
    
    @Column(nullable = false, length = 50)
    private String portadaImg;
    
    @Column(nullable = false, length = 100)
    private String frase;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;
    

    
}
