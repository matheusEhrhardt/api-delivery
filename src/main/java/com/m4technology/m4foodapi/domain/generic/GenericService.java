package com.m4technology.m4foodapi.domain.generic;

import com.m4technology.m4foodapi.domain.exception.EntidadeEmUsoExeption;
import com.m4technology.m4foodapi.domain.exception.EntidadeNaoEncontradaException;
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

    public Optional<E> buscarPorId(Long id){
        Optional<E> model = repository.findById(id);

        if (model.isEmpty()){
            throw new EntidadeNaoEncontradaException(String.format("Não existe registro com identificador %d", id));
        }

        return model;
    }

    public E salvar(E model){
        return (E) repository.save(model);
    }

    public Optional<E> salvar(E model, Long id){
        Optional<E> modelExistente = buscarPorId(id);

        if (modelExistente.isEmpty()){
            throw new EntidadeNaoEncontradaException(String.format("Não existe registro com identificador %d", id));
        }

        BeanUtils.copyProperties(model,modelExistente, "id");
        return (Optional<E>) repository.save(model);
    }

    public void excluir(Long id){
        try {
            repository.deleteById(id);

        } catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe registro com identificador %d", id));
        } catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoExeption(
                    String.format("O registro com identificador %d não pode ser removido, pois está em uso", id));
        }
    }
}
