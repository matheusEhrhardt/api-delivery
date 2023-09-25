package com.m4technology.m4foodapi.domain.service;

import com.m4technology.m4foodapi.domain.generic.GenericService;
import com.m4technology.m4foodapi.domain.model.Endereco;
import com.m4technology.m4foodapi.domain.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends GenericService<EnderecoRepository, Endereco> {
}
