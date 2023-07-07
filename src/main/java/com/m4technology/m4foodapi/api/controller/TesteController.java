package com.m4technology.m4foodapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@EnableAsync
public class TesteController {

    @Autowired
    TesteTask task;
    private Integer ii = 4000;
    @GetMapping("/")
    public void teste() throws InterruptedException {
        List<Integer> lista = Arrays.asList(1,2,3,4,5);
        for (Integer i : lista) {
            if (i % 2 == 0){
                task.execute(ii,i);
            } else {
                task.execute(0,i);
            }
        }
    }
}
