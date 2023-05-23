package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.DeliveryStatus;
import com.algaworks.algalog.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OccurenceRegistryService {
    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public Occurrence registry(Long deliveryId, String description) {
        Delivery delivery = searchDeliveryService.search(deliveryId);
        if(!delivery.getStatus().equals(DeliveryStatus.PENDING)){
            throw new BusinessException("Can not registry an occurrence in a delivery that already was cancel or finished");
        }
        return delivery.registryOccurence(description);
    }
}
