package com.m4technology.m4foodapi.domain.generic;

import com.m4technology.m4foodapi.domain.exception.EntidadeEmUsoExeption;
import com.m4technology.m4foodapi.domain.exception.EntidadeNaoEncontradaException;
import com.m4technology.m4foodapi.domain.exception.NegocioException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class GenericService<T extends JpaRepository, E>{
    
    @Autowired
    protected T repository;

    public List<E> buscarTodos(){
        return repository.findAll();
    }

    public E buscarPorId(Long id) {
        Optional<E> model = repository.findById(id);
        if (model.isEmpty()){
            throw new EntidadeNaoEncontradaException();
        }
        return model.get();
    }

    public E salvar(E model){
        try {
            return (E) repository.save(model);
        } catch (NegocioException e){
            throw new NegocioException();
        }
    }

    public E salvar(E model, Long id){
        E modelExistente = buscarPorId(id);
        BeanUtils.copyProperties(model,modelExistente, "id");
        try {
            return (E) repository.save(model);
        } catch (NegocioException e){
            throw new NegocioException();
        }
    }

    public void excluir(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException();
        } catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoExeption();
        }
    }
}
