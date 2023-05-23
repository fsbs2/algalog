package com.algaworks.algalog.api.controllers;

import com.algaworks.algalog.api.dto.CompleteDeliveryDto;
import com.algaworks.algalog.api.dto.DeliveryDto;
import com.algaworks.algalog.api.dto.request.DeliveryRequestModel;
import com.algaworks.algalog.api.dto.request.OccurenceInput;
import com.algaworks.algalog.api.mapping.DeliveryMapper;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliverys")
public class DeliveryController {
    private DeliveryService deliveryService;
    private DeliveryRepository deliveryRepository;
    private DeliveryMapper deliveryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDto request(@Valid @RequestBody DeliveryRequestModel deliveryRequestModel) {
        var deliveryCreated = deliveryService.requestDelivery(deliveryMapper.toDeliveryEntity(deliveryRequestModel));
        return deliveryMapper.toDto(deliveryCreated);
    }

    @GetMapping
    public List<DeliveryDto> findAll() {
        return deliveryMapper.toCollectionDto(deliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompleteDeliveryDto> findById(@PathVariable Long id) {
        return deliveryRepository.findById(id)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toCompleteDto(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizeDelivery(@PathVariable Long id) {
        deliveryService.finish(id);
    }
    @PutMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelDelivery(@PathVariable Long id, @RequestBody @Valid OccurenceInput occurenceInput) {
        deliveryService.cancel(id,occurenceInput);
    }
}
