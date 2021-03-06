package cl.escalab.nparrado.spring.homework2_2.service.impl;

import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNoExistenteException;
import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNuloException;
import cl.escalab.nparrado.spring.homework2_2.model.GuiaDespacho;
import cl.escalab.nparrado.spring.homework2_2.repo.GuiaDespachoRepoInterface;
import cl.escalab.nparrado.spring.homework2_2.service.GuiaDespachoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuiaDespachoServiceImpl implements GuiaDespachoService {

    @Autowired
    private GuiaDespachoRepoInterface repoInterface;


    @Override
    public GuiaDespacho registrar(GuiaDespacho obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("GuiaDespacho ingresada no puede ser nula");
        }
        return repoInterface.save(obj);
    }

    @Override
    public ResponseEntity<GuiaDespacho> registrarEntity(GuiaDespacho obj) {
        GuiaDespacho g;
        try {
            g = registrar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new GuiaDespacho(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public GuiaDespacho modificar(GuiaDespacho obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("GuiaDespacho ingresada no puede ser nula");
        }
        return null;
    }

    @Override
    public ResponseEntity<GuiaDespacho> modificarEntity(GuiaDespacho obj) {
        GuiaDespacho g;
        try {
            g = modificar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new GuiaDespacho(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public List<GuiaDespacho> listar() {
        return repoInterface.findAll();
    }

    @Override
    public ResponseEntity<List<GuiaDespacho>> listarEntity() {
        return new ResponseEntity<>(listar(), HttpStatus.OK);
    }

    @Override
    public GuiaDespacho leerPorId(Integer id) throws ObjetoNuloException, ObjetoNoExistenteException {
        if (id == null) {
            throw new ObjetoNuloException("id de GuiaDespacho ingresada no puede ser nulo");
        }
        Optional<GuiaDespacho> optional = repoInterface.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNoExistenteException("GuiaDespacho con id " + id + " no existe");
        }
    }

    @Override
    public ResponseEntity<GuiaDespacho> leerPorIdEntity(Integer id) {
        GuiaDespacho g;
        try {
            g = leerPorId(id);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new GuiaDespacho(), HttpStatus.BAD_REQUEST);
        } catch (ObjetoNoExistenteException e) {
            return new ResponseEntity<>(new GuiaDespacho(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Boolean eliminar(Integer id) throws ObjetoNuloException {
        if (id == null) {
            throw new ObjetoNuloException("id de GuiaDespacho ingresada no puede ser nulo");
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
