package cl.escalab.nparrado.spring.homework2_2.service;

import cl.escalab.nparrado.spring.homework2_2.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService extends ICRUD<Item> {

    ResponseEntity<Item> registrarEntity(Item obj);

    ResponseEntity<Item> modificarEntity(Item obj);

    ResponseEntity<List<Item>> listarEntity();

    ResponseEntity<Item> leerPorIdEntity(Integer id);

    ResponseEntity<Boolean> eliminarEntity(Integer id);
}
