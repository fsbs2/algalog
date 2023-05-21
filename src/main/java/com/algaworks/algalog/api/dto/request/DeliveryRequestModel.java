package com.algaworks.algalog.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryRequestModel {
    @Valid
    @NotNull
    private ClientIdRequest client;

    @Valid
    @NotNull
    private AdresserInput adresser;

    @NotNull
    private BigDecimal tax;
}
