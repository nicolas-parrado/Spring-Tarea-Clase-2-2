package cl.escalab.nparrado.spring.homework2_2.service;

import cl.escalab.nparrado.spring.homework2_2.model.GuiaDespacho;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuiaDespachoService extends ICRUD<GuiaDespacho> {

    ResponseEntity<GuiaDespacho> registrarEntity(GuiaDespacho obj);

    ResponseEntity<GuiaDespacho> modificarEntity(GuiaDespacho obj);

    ResponseEntity<List<GuiaDespacho>> listarEntity();

    ResponseEntity<GuiaDespacho> leerPorIdEntity(Integer id);

    ResponseEntity<Boolean> eliminarEntity(Integer id);
}
