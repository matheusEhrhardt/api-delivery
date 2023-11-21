package com.m4technology.m4foodapi.domain.generic;

import com.m4technology.m4foodapi.domain.exception.EntidadeEmUsoExeption;
import com.m4technology.m4foodapi.domain.exception.EntidadeNaoEncontradaException;
import com.m4technology.m4foodapi.domain.exception.NegocioException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenericService<T extends GenericRepository, E extends GenericModel>{
    
    @Autowired
    protected T repository;

    private final E model = (E) new GenericModel();

    public List<E> buscarPorParametros(HashMap<String,Object> parametros){
        String jpql = montarJpqlBuscarPorParametros(parametros);
        repository.setJpqlBuscarPorParametros(jpql);
        return repository.findByParametros();
    }

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

    private String montarJpqlBuscarPorParametros(HashMap<String,Object> parametros){
        List<String> atributos = Arrays.stream(model.getClass().getDeclaredFields())
                .map(a -> a.getName())
                .collect(Collectors.toList());

        String sql = "FROM " + model.getClass().getSimpleName();

        int numAtributos = 0;

        for (String atributo : atributos) {
            for (String chave : parametros.keySet()) {
                if (!atributo.toUpperCase().equals(chave.toUpperCase())) continue;
                sql = numAtributos == 0 ? sql.concat(" WHERE ") : sql.concat(" AND ");
                sql = sql.concat(atributo).concat(" = ").concat(String.valueOf(parametros.get(chave)));
                numAtributos++;
                break;
            }
        }

        return sql;
    }

}
