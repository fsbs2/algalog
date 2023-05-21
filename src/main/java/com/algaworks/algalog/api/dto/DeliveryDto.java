package com.algaworks.algalog.api.dto;

import com.algaworks.algalog.domain.model.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDto {
    private Long id;
    private ClientShortModel client;
    private AdresserDto adresser;
    private BigDecimal tax;
    private DeliveryStatus status;
    private OffsetDateTime startDelivery;
    private OffsetDateTime endDelivery;
}
