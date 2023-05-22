package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EndDeliveryService {
    private DeliveryRepository deliveryRepository;
    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public void finish(Long id) {
        Delivery delivery = searchDeliveryService.search(id);
        delivery.finalizeDelivery();
        deliveryRepository.save(delivery);
    }
}
