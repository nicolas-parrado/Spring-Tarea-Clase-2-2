package cl.escalab.nparrado.spring.homework2_2.service.impl;

import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNoExistenteException;
import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNuloException;
import cl.escalab.nparrado.spring.homework2_2.model.Ruta;
import cl.escalab.nparrado.spring.homework2_2.repo.RutaRepoInterface;
import cl.escalab.nparrado.spring.homework2_2.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaServiceImpl implements RutaService {

    @Autowired
    private RutaRepoInterface repoInterface;


    @Override
    public Ruta registrar(Ruta obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("Ruta ingresada no puede ser nula");
        }
        return repoInterface.save(obj);
    }

    @Override
    public ResponseEntity<Ruta> registrarEntity(Ruta obj) {
        Ruta g;
        try {
            g = registrar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Ruta(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Ruta modificar(Ruta obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("Ruta ingresada no puede ser nula");
        }
        return null;
    }

    @Override
    public ResponseEntity<Ruta> modificarEntity(Ruta obj) {
        Ruta g;
        try {
            g = modificar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Ruta(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public List<Ruta> listar() {
        return repoInterface.findAll();
    }

    @Override
    public ResponseEntity<List<Ruta>> listarEntity() {
        return new ResponseEntity<>(listar(), HttpStatus.OK);
    }

    @Override
    public Ruta leerPorId(Integer id) throws ObjetoNuloException, ObjetoNoExistenteException {
        if (id == null) {
            throw new ObjetoNuloException("id de Ruta ingresada no puede ser nulo");
        }
        Optional<Ruta> optional = repoInterface.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNoExistenteException("Ruta con id " + id + " no existe");
        }
    }

    @Override
    public ResponseEntity<Ruta> leerPorIdEntity(Integer id) {
        Ruta g;
        try {
            g = leerPorId(id);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Ruta(), HttpStatus.BAD_REQUEST);
        } catch (ObjetoNoExistenteException e) {
            return new ResponseEntity<>(new Ruta(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Boolean eliminar(Integer id) throws ObjetoNuloException {
        if (id == null) {
            throw new ObjetoNuloException("id de Ruta ingresada no puede ser nulo");
        }
        repoInterface.deleteById(id);
        return true;
    }


    @Override
    public ResponseEntity<Boolean> eliminarEntity(Integer id) {
        Boolean resp;
        try {
            resp = eliminar(id);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
