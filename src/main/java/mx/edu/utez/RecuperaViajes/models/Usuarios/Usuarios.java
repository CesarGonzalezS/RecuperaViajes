package mx.edu.utez.RecuperaViajes.models.Usuarios;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.RecuperaViajes.models.Viajes.Viajes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Setter
@Getter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 150)
    private String name;
    @Column(name = "email",nullable = false,length = 150)
    private String email;
    @Column(name = "date",nullable = false,length = 150)
    private String date;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Viajes> viajes;
}



