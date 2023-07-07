package com.m4technology.m4foodapi.domain.generic;

import com.m4technology.m4foodapi.domain.exception.EntidadeEmUsoExeption;
import com.m4technology.m4foodapi.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class GenericController<T extends GenericService, E>{

    @Autowired
    protected T service;

    @GetMapping
    public ResponseEntity<List<E>> bucar(){
        List<E> lista = service.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> bucarPorId(Long id){
        Optional<E> model = service.buscarPorId(id);

        if (model.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(model.orElse(null));
    }

    @PostMapping
    public ResponseEntity<E> cadastrar(@RequestBody E model){
        try {
            E modelNovo = (E) service.salvar(model);
            return ResponseEntity.status(HttpStatus.CREATED).body(modelNovo);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<E> editar(@RequestBody E model, @PathVariable Long id){
        try {
            Optional<E> modelNovo = service.salvar(model,id);
            return ResponseEntity.ok(modelNovo.get());
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<E> excluir(@PathVariable Long id){
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build();

        } catch (EntidadeEmUsoExeption e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/BuscarPorParametro")
    public ResponseEntity<List<E>> buscarPorParametro(@RequestParam(required = false) String parametro){
        return null;
    }

}


