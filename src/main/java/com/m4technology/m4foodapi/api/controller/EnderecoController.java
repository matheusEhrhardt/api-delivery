package com.m4technology.m4foodapi.api.controller;


import com.m4technology.m4foodapi.domain.generic.GenericController;
import com.m4technology.m4foodapi.domain.model.Endereco;
import com.m4technology.m4foodapi.domain.service.EnderecoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enderecos")
public class EnderecoController extends GenericController<EnderecoService, Endereco> {
}
