package cl.escalab.nparrado.spring.homework2_2.service;

import cl.escalab.nparrado.spring.homework2_2.model.Vehiculo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehiculoService extends ICRUD<Vehiculo> {

    ResponseEntity<Vehiculo> registrarEntity(Vehiculo obj);

    ResponseEntity<Vehiculo> modificarEntity(Vehiculo obj);

    ResponseEntity<List<Vehiculo>> listarEntity();

    ResponseEntity<Vehiculo> leerPorIdEntity(Integer id);

    ResponseEntity<Boolean> eliminarEntity(Integer id);
}
