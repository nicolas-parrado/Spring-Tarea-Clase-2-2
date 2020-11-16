package cl.escalab.nparrado.spring.homework2_2.service.impl;

import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNoExistenteException;
import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNuloException;
import cl.escalab.nparrado.spring.homework2_2.model.GuiaDespacho;
import cl.escalab.nparrado.spring.homework2_2.repo.GuiaDespachoRepoInterface;
import cl.escalab.nparrado.spring.homework2_2.service.GuiaDespachoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public GuiaDespacho modificar(GuiaDespacho obj) throws ObjetoNuloException {
        //TODO
        return null;
    }

    @Override
    public List<GuiaDespacho> listar() {
        //TODO
        return null;
    }

    @Override
    public GuiaDespacho leeerPorId(Integer id) throws ObjetoNuloException, ObjetoNoExistenteException {
        //TODO
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws ObjetoNuloException, ObjetoNoExistenteException {
        //TODO
        return false;
    }
}
