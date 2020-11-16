package cl.escalab.nparrado.spring.homework2_2.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;

    @NotNull
    @Column(name = "marca", nullable = false, length = 30)
    private String marca;

    @NotNull
    @Column(name = "modelo", nullable = false, length = 30)
    private String modelo;

    @NotNull
    @Column(name = "anio", nullable = false)
    private Integer anio;

    @NotNull
    @Column(name = "color", nullable = false, length = 30)
    private String color;

    @NotNull
    @Column(name = "patente", nullable = false, length = 10)
    private String patente;
}
