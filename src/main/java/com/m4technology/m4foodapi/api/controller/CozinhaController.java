package com.m4technology.m4foodapi.api.controller;

import com.m4technology.m4foodapi.domain.generic.GenericController;
import com.m4technology.m4foodapi.domain.model.Cozinha;
import com.m4technology.m4foodapi.domain.service.CozinhaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController extends GenericController<CozinhaService, Cozinha> {
}
