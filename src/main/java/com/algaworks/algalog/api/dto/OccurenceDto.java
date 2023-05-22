package com.algaworks.algalog.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurenceDto {
    private Long id;
    private String description;
    private OffsetDateTime registrationDate;
}
