package cl.escalab.nparrado.spring.homework2_2.controller;

import cl.escalab.nparrado.spring.homework2_2.model.Ruta;
import cl.escalab.nparrado.spring.homework2_2.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ruta")
public class RutaControlller {
    @Autowired
    private RutaService service;

    @GetMapping
    public ResponseEntity<List<Ruta>> listar() {
        return service.listarEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruta> listarPorId(@PathVariable("id") Integer id) {
        return service.leerPorIdEntity(id);
    }

    @PostMapping
    public ResponseEntity<Ruta> registrar(@Valid @RequestBody Ruta obj) {
        return service.registrarEntity(obj);
    }

    @PutMapping
    public ResponseEntity<Ruta> modificar(@Valid @RequestBody Ruta obj) {
        return service.modificarEntity(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) {
        return service.eliminarEntity(id);
    }
}
