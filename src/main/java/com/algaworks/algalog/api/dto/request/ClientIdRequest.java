package com.algaworks.algalog.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientIdRequest {
    @NotNull
    private Long id;
}
