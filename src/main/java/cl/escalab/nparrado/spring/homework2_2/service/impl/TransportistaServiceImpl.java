package cl.escalab.nparrado.spring.homework2_2.service.impl;

import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNoExistenteException;
import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNuloException;
import cl.escalab.nparrado.spring.homework2_2.model.Transportista;
import cl.escalab.nparrado.spring.homework2_2.repo.TransportistaRepoInterface;
import cl.escalab.nparrado.spring.homework2_2.service.TransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportistaServiceImpl implements TransportistaService {

    @Autowired
    private TransportistaRepoInterface repoInterface;


    @Override
    public Transportista registrar(Transportista obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("Transportista ingresado no puede ser nulo");
        }
        return repoInterface.save(obj);
    }

    @Override
    public ResponseEntity<Transportista> registrarEntity(Transportista obj) {
        Transportista g;
        try {
            g = registrar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Transportista(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Transportista modificar(Transportista obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("Transportista ingresado no puede ser nulo");
        }
        return null;
    }

    @Override
    public ResponseEntity<Transportista> modificarEntity(Transportista obj) {
        Transportista g;
        try {
            g = modificar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Transportista(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public List<Transportista> listar() {
        return repoInterface.findAll();
    }

    @Override
    public ResponseEntity<List<Transportista>> listarEntity() {
        return new ResponseEntity<>(listar(), HttpStatus.OK);
    }

    @Override
    public Transportista leerPorId(Integer id) throws ObjetoNuloException, ObjetoNoExistenteException {
        if (id == null) {
            throw new ObjetoNuloException("id de Transportista ingresado no puede ser nulo");
        }
        Optional<Transportista> optional = repoInterface.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNoExistenteException("Transportista con id " + id + " no existe");
        }
    }

    @Override
    public ResponseEntity<Transportista> leerPorIdEntity(Integer id) {
        Transportista g;
        try {
            g = leerPorId(id);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Transportista(), HttpStatus.BAD_REQUEST);
        } catch (ObjetoNoExistenteException e) {
            return new ResponseEntity<>(new Transportista(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Boolean eliminar(Integer id) throws ObjetoNuloException {
        if (id == null) {
            throw new ObjetoNuloException("id de Transportista ingresado no puede ser nulo");
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
