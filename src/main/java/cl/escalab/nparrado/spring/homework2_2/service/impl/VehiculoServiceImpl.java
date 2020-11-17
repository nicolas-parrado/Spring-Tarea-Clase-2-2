package cl.escalab.nparrado.spring.homework2_2.service.impl;

import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNoExistenteException;
import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNuloException;
import cl.escalab.nparrado.spring.homework2_2.model.Vehiculo;
import cl.escalab.nparrado.spring.homework2_2.repo.VehiculoRepoInterface;
import cl.escalab.nparrado.spring.homework2_2.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepoInterface repoInterface;


    @Override
    public Vehiculo registrar(Vehiculo obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("Vehiculo ingresado no puede ser nulo");
        }
        return repoInterface.save(obj);
    }

    @Override
    public ResponseEntity<Vehiculo> registrarEntity(Vehiculo obj) {
        Vehiculo g;
        try {
            g = registrar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Vehiculo(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Vehiculo modificar(Vehiculo obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("Vehiculo ingresado no puede ser nulo");
        }
        return null;
    }

    @Override
    public ResponseEntity<Vehiculo> modificarEntity(Vehiculo obj) {
        Vehiculo g;
        try {
            g = modificar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Vehiculo(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public List<Vehiculo> listar() {
        return repoInterface.findAll();
    }

    @Override
    public ResponseEntity<List<Vehiculo>> listarEntity() {
        return new ResponseEntity<>(listar(), HttpStatus.OK);
    }

    @Override
    public Vehiculo leerPorId(Integer id) throws ObjetoNuloException, ObjetoNoExistenteException {
        if (id == null) {
            throw new ObjetoNuloException("id de Vehiculo ingresado no puede ser nulo");
        }
        Optional<Vehiculo> optional = repoInterface.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNoExistenteException("Vehiculo con id " + id + " no existe");
        }
    }

    @Override
    public ResponseEntity<Vehiculo> leerPorIdEntity(Integer id) {
        Vehiculo g;
        try {
            g = leerPorId(id);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Vehiculo(), HttpStatus.BAD_REQUEST);
        } catch (ObjetoNoExistenteException e) {
            return new ResponseEntity<>(new Vehiculo(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Boolean eliminar(Integer id) throws ObjetoNuloException {
        if (id == null) {
            throw new ObjetoNuloException("id de Vehiculo ingresado no puede ser nulo");
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
