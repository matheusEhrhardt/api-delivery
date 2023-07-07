package com.m4technology.m4foodapi.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
