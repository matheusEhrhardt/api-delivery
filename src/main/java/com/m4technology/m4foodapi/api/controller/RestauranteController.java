package com.m4technology.m4foodapi.api.controller;

import com.m4technology.m4foodapi.domain.generic.GenericController;
import com.m4technology.m4foodapi.domain.model.Restaurante;
import com.m4technology.m4foodapi.domain.service.RestauranteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController extends GenericController<RestauranteService, Restaurante> {
}
