package cl.escalab.nparrado.spring.homework2_2.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "guia_despacho")
public class GuiaDespacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGuiaDespacho;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "guia_despacho_item",
            joinColumns = @JoinColumn(name = "id_guia_despacho", referencedColumnName = "idGuiaDespacho"),
            inverseJoinColumns = @JoinColumn(name = "id_item", referencedColumnName = "idItem")
    )
    private List<Item> items;

    @NotNull
    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @NotNull
    @Column(name = "comuna", length = 50, nullable = false)
    private String comuna;

    @NotNull
    @Column(name = "region", length = 50, nullable = false)
    private String region;

    @NotNull
    @Column(name = "pais", length = 50, nullable = false)
    private String pais;

    @Column(name = "nombre_recepcionista", length = 70)
    private String nombreRecepcionista;

    @Column(name = "apellido_recepcionista", length = 70)
    private String apellidoRecepcionista;

    @NotNull
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;
}
