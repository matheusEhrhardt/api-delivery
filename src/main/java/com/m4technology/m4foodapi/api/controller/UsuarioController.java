package com.m4technology.m4foodapi.api.controller;

import com.m4technology.m4foodapi.domain.generic.GenericController;
import com.m4technology.m4foodapi.domain.model.Usuario;
import com.m4technology.m4foodapi.domain.service.UsuariosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends GenericController<UsuariosService, Usuario> {
}
