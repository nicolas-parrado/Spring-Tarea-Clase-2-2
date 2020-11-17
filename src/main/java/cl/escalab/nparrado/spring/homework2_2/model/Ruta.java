package cl.escalab.nparrado.spring.homework2_2.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "ruta")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRuta;

    @ManyToOne
    @JoinColumn(name = "id_transportista", nullable = false, foreignKey = @ForeignKey(name = "FK_ruta_transportista"))
    private Transportista transportista;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "FK_ruta_vehiculo"))
    private Vehiculo vehiculo;

    @ManyToMany
    @JoinTable(
            name = "ruta_guia_despacho",
            joinColumns = @JoinColumn(name = "id_ruta", referencedColumnName = "idRuta"),
            inverseJoinColumns = @JoinColumn(name = "id_guia_despacho", referencedColumnName = "idGuiaDespacho")

    )
    private List<GuiaDespacho> guiasDespacho;

    @Column(name = "fecha_partida")
    private LocalDateTime fechaPartida;

    @Column(name = "fechaLlegada")
    private LocalDateTime fechaLlegada;

    @NotNull
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;
}
