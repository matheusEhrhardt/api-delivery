package com.m4technology.m4foodapi.domain.enums;

public enum ExceptionEnum {
    REGISTRO_NAO_ENCONTRADO("Não existe registro com o identificador informado"),
    ENTIDADE_ESTA_EM_USO("O registro não pode ser removido, pois está em uso"),
    ERRO_AO_PERSISTIR_OS_DADOS("Ocorreu um erro ao tentar persistir os dados"),
    ERRO("Ocorreu um erro ao realizar a operação");

    private final String descricao;

    ExceptionEnum(String descricao) {
        this.descricao = descricao;
    }
    
    public String getValue() {
        return name();
    }
    
    public String getDescricao() {
        return descricao;
    }

}


