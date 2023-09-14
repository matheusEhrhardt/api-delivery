package com.m4technology.m4foodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class ErrorMessage {

    private Integer status;
    private String type;
    private String title;
    private String detail;

}
