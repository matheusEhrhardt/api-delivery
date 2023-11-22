package com.m4technology.m4foodapi.domain.service;

import com.m4technology.m4foodapi.domain.generic.GenericService;
import com.m4technology.m4foodapi.domain.model.FormaPagamento;
import com.m4technology.m4foodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService extends GenericService<FormaPagamentoRepository, FormaPagamento> {
    public FormaPagamentoService() {
        super(new FormaPagamento());
    }
}
