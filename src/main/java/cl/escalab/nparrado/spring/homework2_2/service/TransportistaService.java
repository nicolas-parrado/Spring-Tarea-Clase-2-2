package cl.escalab.nparrado.spring.homework2_2.service;

import cl.escalab.nparrado.spring.homework2_2.model.Transportista;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransportistaService extends ICRUD<Transportista> {

    ResponseEntity<Transportista> registrarEntity(Transportista obj);

    ResponseEntity<Transportista> modificarEntity(Transportista obj);

    ResponseEntity<List<Transportista>> listarEntity();

    ResponseEntity<Transportista> leerPorIdEntity(Integer id);

    ResponseEntity<Boolean> eliminarEntity(Integer id);
}
