package com.algaworks.algalog.algalogapi.controllers;

import com.algaworks.algalog.algalogapi.domain.model.Delivery;
import com.algaworks.algalog.algalogapi.domain.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliverys")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@Valid @RequestBody Delivery delivery){
        return deliveryService.requestDelivery(delivery);
    }

}
