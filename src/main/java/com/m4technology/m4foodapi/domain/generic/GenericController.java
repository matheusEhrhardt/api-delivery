package com.m4technology.m4foodapi.domain.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenericController<T extends GenericService, E>{

    @Autowired
    protected T service;

    @GetMapping
    public List<E> buscar(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public E buscarPorId(@PathVariable Long id){
        return (E) service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public E cadastrar(@RequestBody E model){
        return (E) service.salvar(model);

    }

    @PutMapping("/{id}")
    public E editar(@RequestBody E model, @PathVariable Long id){
        return (E) service.salvar(model,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @GetMapping("/BuscarPorParametro")
    public ResponseEntity<List<E>> buscarPorParametro(@RequestParam(required = false) String parametro){
        return null;
    }
}


