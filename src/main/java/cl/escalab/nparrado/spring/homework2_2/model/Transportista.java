package cl.escalab.nparrado.spring.homework2_2.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "transportista")
public class Transportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransportista;

    @NotNull
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @NotNull
    @Column(name = "apellido", nullable = false, length = 70)
    private String apellido;

    @NotNull
    @Column(name = "tipo_identificacion", nullable = false, length = 20)
    private String tipoIdentificacion;

    @NotNull
    @Column(name = "identificacion", nullable = false, length = 20)
    private String identificacion;
}
