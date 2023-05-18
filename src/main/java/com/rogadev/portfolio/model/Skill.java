
package com.rogadev.portfolio.model;

import javax.persistence.*;

import com.rogadev.portfolio.security.model.Usuario;
import lombok.*;

@Entity
@Table(name = "skills")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSkill;
    
    @Column(nullable = false, length = 30)
    private String titulo;
    
    @Column(nullable = false, length = 30)
    private String skillImg;
    
    @Column(nullable = false)
    private String porcentaje;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

}
