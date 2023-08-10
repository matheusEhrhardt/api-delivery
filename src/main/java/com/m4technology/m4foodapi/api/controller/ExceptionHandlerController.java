package com.m4technology.m4foodapi.api.controller;

import com.m4technology.m4foodapi.domain.exception.EntidadeNaoEncontradaException;
import com.m4technology.m4foodapi.domain.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> tratarEntidadeNãoEncontradaException(EntidadeNaoEncontradaException e){
        ErrorMessage error = ErrorMessage.builder()
                .mensagem(e.getMessage())
                .dataHora(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
