package com.algaworks.algalog.api.mapping;

import com.algaworks.algalog.api.dto.CompleteDeliveryDto;
import com.algaworks.algalog.api.dto.DeliveryDto;
import com.algaworks.algalog.api.dto.request.DeliveryRequestModel;
import com.algaworks.algalog.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryMapper {
    private ModelMapper modelMapper;

    public DeliveryDto toDto(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryDto.class);
    }

    public List<DeliveryDto> toCollectionDto(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Delivery toDeliveryEntity(DeliveryRequestModel requestModel) {
        return modelMapper.map(requestModel, Delivery.class);
    }

    public CompleteDeliveryDto toCompleteDto(Delivery delivery) {
        return modelMapper.map(delivery, CompleteDeliveryDto.class);
    }
}
