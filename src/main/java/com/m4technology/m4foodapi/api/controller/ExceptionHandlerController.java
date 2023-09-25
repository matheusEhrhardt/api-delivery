package com.m4technology.m4foodapi.api.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.m4technology.m4foodapi.domain.enums.ExceptionEnum;
import com.m4technology.m4foodapi.domain.exception.EntidadeNaoEncontradaException;
import com.m4technology.m4foodapi.domain.model.ErrorMessage;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        if (rootCause instanceof InvalidFormatException){
            return handleInvalidFormatException((InvalidFormatException) rootCause,headers,status,request);
        }

        return super.handleHttpMessageNotReadable(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ExceptionEnum exceptionEnum = ExceptionEnum.MENSAGEM_INCOMPREENSIVEL;
        String detail = String.format("A propiedade '%s' recebeu o valor '%s', " +
                "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.","a","b","c");
        ProblemDetail problem = this.createProblemDetail(ex, status, detail, (String)null, null, request);
        return handleExceptionInternal(ex,problem,headers,status,request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNãoEncontradaException(EntidadeNaoEncontradaException ex,WebRequest request){

        ErrorMessage body = ErrorMessage.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .title(ExceptionEnum.REGISTRO_NAO_ENCONTRADO.getDescricao())
                .type(ExceptionEnum.REGISTRO_NAO_ENCONTRADO.getUri())
                .detail(ex.getMessage())
                .build();

        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatusCode statusCode, WebRequest request) {

        if(body == null) {
            body = ErrorMessage.builder()
                    .status(statusCode.value())
                    .detail(ex.getMessage())
                    .type(ExceptionEnum.ERRO.getUri())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        BindingResult bindingResult = ex.getBindingResult();

        List<ErrorMessage.Field> fields = bindingResult.getFieldErrors()
                .stream()
                .map(fieldError -> {
                    String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                    return ErrorMessage.Field
                        .builder()
                        .name(fieldError.getField())
                        .userMessage(message).build();})
                .collect(Collectors.toList());

        ErrorMessage body = ErrorMessage.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title(ExceptionEnum.DADOS_INVALIDOS.getDescricao())
                .type(ExceptionEnum.DADOS_INVALIDOS.getUri())
                .detail(ExceptionEnum.DADOS_INVALIDOS.getDescricao())
                .fields(fields)
                .build();

        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
