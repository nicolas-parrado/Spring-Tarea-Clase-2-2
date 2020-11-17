package cl.escalab.nparrado.spring.homework2_2.controller;

import cl.escalab.nparrado.spring.homework2_2.model.Transportista;
import cl.escalab.nparrado.spring.homework2_2.service.TransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("transportista")
public class TransportistaController {
    @Autowired
    private TransportistaService service;

    @GetMapping
    public ResponseEntity<List<Transportista>> listar() {
        return service.listarEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transportista> listarPorId(@PathVariable("id") Integer id) {
        return service.leerPorIdEntity(id);
    }

    @PostMapping
    public ResponseEntity<Transportista> registrar(@Valid @RequestBody Transportista obj) {
        return service.registrarEntity(obj);
    }

    @PutMapping
    public ResponseEntity<Transportista> modificar(@Valid @RequestBody Transportista obj) {
        return service.modificarEntity(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) {
        return service.eliminarEntity(id);
    }
}
