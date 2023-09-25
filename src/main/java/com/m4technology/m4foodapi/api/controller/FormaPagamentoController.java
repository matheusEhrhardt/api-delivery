package com.m4technology.m4foodapi.api.controller;

import com.m4technology.m4foodapi.domain.generic.GenericController;
import com.m4technology.m4foodapi.domain.model.FormaPagamento;
import com.m4technology.m4foodapi.domain.service.FormaPagamentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("formas-pagamento")
public class FormaPagamentoController extends GenericController<FormaPagamentoService, FormaPagamento> {
}
