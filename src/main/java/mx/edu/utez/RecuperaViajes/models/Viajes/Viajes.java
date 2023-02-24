package mx.edu.utez.RecuperaViajes.models.Viajes;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.RecuperaViajes.models.Destinos.Destinos;
import mx.edu.utez.RecuperaViajes.models.Usuarios.Usuarios;

import javax.persistence.*;

@Entity
@Table(name = "viajes")
@NoArgsConstructor
@Setter
@Getter
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "departure",nullable = false, unique = true, length = 150)
    private String desparture;
    @Column(name = "arrival", nullable = false, length = 150)
    private String arrival;

    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Destinos destinos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;

}



