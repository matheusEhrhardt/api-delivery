package com.m4technology.m4foodapi.domain.repository;

import com.m4technology.m4foodapi.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento,Long> {
}
