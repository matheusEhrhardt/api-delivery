package com.m4technology.m4foodapi.api.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TesteTask {

    @Async
    public void execute(Integer a, Integer print) throws InterruptedException {
        Thread.sleep(a);
        System.out.println(print);
    }
}
