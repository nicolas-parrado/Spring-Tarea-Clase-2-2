package cl.escalab.nparrado.spring.homework2_2.service;

import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNoExistenteException;
import cl.escalab.nparrado.spring.homework2_2.exception.ObjetoNuloException;

import java.util.List;

public interface ICRUD<T> {

    T registrar(T obj) throws ObjetoNuloException;

    T modificar(T obj) throws ObjetoNuloException;

    List<T> listar();

    T leerPorId(Integer id) throws ObjetoNuloException, ObjetoNoExistenteException;

    Boolean eliminar(Integer id) throws ObjetoNuloException;

}
