package com.m4technology.m4foodapi.domain.service;

import com.m4technology.m4foodapi.domain.model.Cozinha;
import com.m4technology.m4foodapi.domain.repository.CozinhaRepository;
import com.m4technology.m4foodapi.domain.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService extends GenericService<CozinhaRepository, Cozinha> {

    public CozinhaService() {
        super(new Cozinha());
    }
}
