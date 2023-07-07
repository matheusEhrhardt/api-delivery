package com.m4technology.m4foodapi.domain.model;

public class ErrorMessage {

    private String titulo;

    private String mensagem;

    private Integer status;

    public ErrorMessage(String titulo, String mensagem, Integer status) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
