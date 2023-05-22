package com.algaworks.algalog.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurenceInput {
    @NotBlank
    private String description;
}
