package com.m4technology.m4foodapi.api.controller;

import com.m4technology.m4foodapi.domain.model.Cozinha;
import com.m4technology.m4foodapi.domain.service.CozinhaService;
import com.m4technology.m4foodapi.domain.generic.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cozinhas")
public class CozinhaController extends GenericController<CozinhaService, Cozinha> {
}
