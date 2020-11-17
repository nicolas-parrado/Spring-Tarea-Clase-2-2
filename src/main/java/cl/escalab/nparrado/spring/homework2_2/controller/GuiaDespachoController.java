package cl.escalab.nparrado.spring.homework2_2.controller;

import cl.escalab.nparrado.spring.homework2_2.model.GuiaDespacho;
import cl.escalab.nparrado.spring.homework2_2.service.GuiaDespachoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/guia_despacho")
public class GuiaDespachoController {

    @Autowired
    private GuiaDespachoService service;

    @GetMapping
    public ResponseEntity<List<GuiaDespacho>> listar() {
        return service.listarEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuiaDespacho> listarPorId(@PathVariable("id") Integer id) {
        return service.leerPorIdEntity(id);
    }

    @PostMapping
    public ResponseEntity<GuiaDespacho> registrar(@Valid @RequestBody GuiaDespacho obj) {
        return service.registrarEntity(obj);
    }

    @PutMapping
    public ResponseEntity<GuiaDespacho> modificar(@Valid @RequestBody GuiaDespacho obj) {
        return service.modificarEntity(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable("id") Integer id) {
        return service.eliminarEntity(id);
    }
}
