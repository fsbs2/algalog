package com.algaworks.algalog.api.controllers;

import com.algaworks.algalog.api.dto.OccurenceDto;
import com.algaworks.algalog.api.dto.request.OccurenceInput;
import com.algaworks.algalog.api.mapping.OccurenceMapper;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Occurrence;
import com.algaworks.algalog.domain.service.OccurenceRegistryService;
import com.algaworks.algalog.domain.service.SearchDeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliverys/{deliveryId}/occurences")
public class OccurenceController {

    private OccurenceRegistryService occurenceRegistryService;
    private SearchDeliveryService searchDeliveryService;

    OccurenceMapper occurenceMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurenceDto registryOccurence(@PathVariable Long deliveryId, @RequestBody @Valid OccurenceInput description){
        Occurrence registry = occurenceRegistryService.registry(deliveryId, description.getDescription());
        return occurenceMapper.toDto(registry);
    }
    @GetMapping
    public List<OccurenceDto> findAll(@PathVariable Long deliveryId){
        Delivery delivery = searchDeliveryService.search(deliveryId);
        return occurenceMapper.toList(delivery.getOccurrences());
    }


}
