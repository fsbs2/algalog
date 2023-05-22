package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OccurenceRegistryService {
    private SearchDeliveryService deliveryService;

    @Transactional
    public Occurrence registry(Long deliveryId, String description) {
        Delivery delivery = deliveryService.search(deliveryId);
        return delivery.registryOccurence(description);
    }
}
