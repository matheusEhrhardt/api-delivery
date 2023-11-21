package com.m4technology.m4foodapi.domain.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenericRepository<T, ID> extends JpaRepository<T,ID> {
    String jpqlBuscarPorParametros = "";

    @Query(value = jpqlBuscarPorParametros)
    List<T> findByParametros();

    void setJpqlBuscarPorParametros(String jpql);
}
