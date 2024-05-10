package com.m4technology.m4foodapi.domain.service;

import com.m4technology.m4foodapi.domain.generic.GenericService;
import com.m4technology.m4foodapi.domain.model.Cozinha;
import com.m4technology.m4foodapi.domain.model.Usuario;
import com.m4technology.m4foodapi.domain.repository.CozinhaRepository;
import com.m4technology.m4foodapi.domain.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService extends GenericService<UsuariosRepository, Usuario> {

    public UsuariosService() {
        super(new Usuario());
    }
}
