package com.m4technology.m4foodapi.domain.exception;

import com.m4technology.m4foodapi.domain.enums.ExceptionEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeEmUsoExeption extends RuntimeException{

    public EntidadeEmUsoExeption(){
        super(ExceptionEnum.ENTIDADE_ESTA_EM_USO.getDescricao());
    }

    public EntidadeEmUsoExeption(String mensagem){
        super(mensagem);
    }
}
