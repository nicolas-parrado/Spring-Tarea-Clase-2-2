package cl.escalab.nparrado.spring.homework2_2.service;

import cl.escalab.nparrado.spring.homework2_2.model.Ruta;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RutaService extends ICRUD<Ruta> {

    ResponseEntity<Ruta> registrarEntity(Ruta obj);

    ResponseEntity<Ruta> modificarEntity(Ruta obj);

    ResponseEntity<List<Ruta>> listarEntity();

    ResponseEntity<Ruta> leerPorIdEntity(Integer id);

    ResponseEntity<Boolean> eliminarEntity(Integer id);
}
