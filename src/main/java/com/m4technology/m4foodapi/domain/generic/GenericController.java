package com.m4technology.m4foodapi.domain.generic;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GenericController<T extends GenericService, E extends GenericModel>{

    @Autowired
    protected T service;

    protected E model = (E) new GenericModel();

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
    public E cadastrar(@RequestBody @Valid E model){
        return (E) service.salvar(model);

    }

    @PutMapping("/{id}")
    public E editar(@RequestBody @Valid E model, @PathVariable Long id){
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


