package com.m4technology.m4foodapi.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class ErrorMessage {

    private LocalDateTime dataHora;
    private String mensagem;

}
