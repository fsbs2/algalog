package com.algaworks.algalog.api.dto;

import com.algaworks.algalog.domain.model.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class CompleteDeliveryDto {
    private Long id;
    private ClientShortModel client;
    private AdresserDto adresser;
    private BigDecimal tax;
    private List<OccurenceDto> occurrences;
    private DeliveryStatus status;
    private OffsetDateTime startDelivery;
    private OffsetDateTime endDelivery;

}
