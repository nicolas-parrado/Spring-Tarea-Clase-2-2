package cl.escalab.nparrado.spring.homework2_2.controller;

import cl.escalab.nparrado.spring.homework2_2.model.Item;
import cl.escalab.nparrado.spring.homework2_2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping
    public ResponseEntity<List<Item>> listar() {
        return service.listarEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> listarPorId(@PathVariable("id") Integer id) {
        return service.leerPorIdEntity(id);
    }

    @PostMapping
    public ResponseEntity<Item> registrar(@Valid @RequestBody Item obj) {
        return service.registrarEntity(obj);
    }

    @PutMapping
    public ResponseEntity<Item> modificar(@Valid @RequestBody Item obj) {
        return service.modificarEntity(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) {
        return service.eliminarEntity(id);
    }
}
