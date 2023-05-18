package com.algaworks.algalog.algalogapi.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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
