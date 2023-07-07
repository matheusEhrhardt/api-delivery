package com.m4technology.m4foodapi.domain.service;

import com.m4technology.m4foodapi.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativar(Cliente cliente){
        cliente.ativar();
        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }

    //    @PostConstruct
    public void init(){
        System.out.println("INIT");
    }

    //    @PreDestroy
    public void destroy(){
        System.out.println("DESTROY");
    }
}
