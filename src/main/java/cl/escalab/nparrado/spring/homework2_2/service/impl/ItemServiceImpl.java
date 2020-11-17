package cl.escalab.nparrado.spring.homework2_2.service.impl;

import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNoExistenteException;
import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNuloException;
import cl.escalab.nparrado.spring.homework2_2.model.Item;
import cl.escalab.nparrado.spring.homework2_2.repo.ItemRepoInterface;
import cl.escalab.nparrado.spring.homework2_2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepoInterface repoInterface;


    @Override
    public Item registrar(Item obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("Item ingresado no puede ser nulo");
        }
        return repoInterface.save(obj);
    }

    @Override
    public ResponseEntity<Item> registrarEntity(Item obj) {
        Item g;
        try {
            g = registrar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Item(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Item modificar(Item obj) throws ObjetoNuloException {
        if (obj == null) {
            throw new ObjetoNuloException("Item ingresado no puede ser nulo");
        }
        return null;
    }

    @Override
    public ResponseEntity<Item> modificarEntity(Item obj) {
        Item g;
        try {
            g = modificar(obj);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Item(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public List<Item> listar() {
        return repoInterface.findAll();
    }

    @Override
    public ResponseEntity<List<Item>> listarEntity() {
        return new ResponseEntity<>(listar(), HttpStatus.OK);
    }

    @Override
    public Item leerPorId(Integer id) throws ObjetoNuloException, ObjetoNoExistenteException {
        if (id == null) {
            throw new ObjetoNuloException("id de Item ingresado no puede ser nulo");
        }
        Optional<Item> optional = repoInterface.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNoExistenteException("Item con id " + id + " no existe");
        }
    }

    @Override
    public ResponseEntity<Item> leerPorIdEntity(Integer id) {
        Item g;
        try {
            g = leerPorId(id);
        } catch (ObjetoNuloException e) {
            return new ResponseEntity<>(new Item(), HttpStatus.BAD_REQUEST);
        } catch (ObjetoNoExistenteException e) {
            return new ResponseEntity<>(new Item(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(g, HttpStatus.OK);
    }

    @Override
    public Boolean eliminar(Integer id) throws ObjetoNuloException {
        if (id == null) {
            throw new ObjetoNuloException("id de Item ingresado no puede ser nulo");
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
