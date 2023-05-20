package com.algaworks.algalog.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Error {
    private Integer status;
    private LocalDateTime dateHour;
    private String title;
    List<Field> fields;

    @AllArgsConstructor
    @Getter
    public static class Field {
        private String name;
        private String mensagem;
    }

}
