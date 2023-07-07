package com.m4technology.m4foodapi.config;

import com.m4technology.m4foodapi.domain.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;

//@Configuration
public class ServiceConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AtivacaoClienteService ativacaoCliente() {
        return new AtivacaoClienteService();
    }
}
