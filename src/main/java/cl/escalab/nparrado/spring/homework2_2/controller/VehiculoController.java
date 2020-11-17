package cl.escalab.nparrado.spring.homework2_2.controller;

import cl.escalab.nparrado.spring.homework2_2.model.Vehiculo;
import cl.escalab.nparrado.spring.homework2_2.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    private VehiculoService service;

    @GetMapping
    public ResponseEntity<List<Vehiculo>> listar() {
        return service.listarEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> listarPorId(@PathVariable("id") Integer id) {
        return service.leerPorIdEntity(id);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> registrar(@Valid @RequestBody Vehiculo obj) {
        return service.registrarEntity(obj);
    }

    @PutMapping
    public ResponseEntity<Vehiculo> modificar(@Valid @RequestBody Vehiculo obj) {
        return service.modificarEntity(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) {
        return service.eliminarEntity(id);
    }
}
