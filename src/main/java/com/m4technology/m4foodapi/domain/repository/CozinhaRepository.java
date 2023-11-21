package com.m4technology.m4foodapi.domain.repository;

import com.m4technology.m4foodapi.domain.generic.GenericRepository;
import com.m4technology.m4foodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends GenericRepository<Cozinha,Long> {

}
