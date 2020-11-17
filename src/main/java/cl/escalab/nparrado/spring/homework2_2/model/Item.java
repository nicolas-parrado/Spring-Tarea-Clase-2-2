package cl.escalab.nparrado.spring.homework2_2.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItem;

    @NotNull
    @Column(name = "sku", nullable = false, unique = true, length = 12)
    private String sku;

    @NotNull
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @NotNull
    @Column(name = "precio", nullable = false)
    private Integer precio;
}
