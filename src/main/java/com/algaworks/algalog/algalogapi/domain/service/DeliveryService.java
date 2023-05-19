package com.algaworks.algalog.algalogapi.domain.service;

import com.algaworks.algalog.algalogapi.domain.model.Client;
import com.algaworks.algalog.algalogapi.domain.model.Delivery;
import com.algaworks.algalog.algalogapi.domain.model.DeliveryStatus;
import com.algaworks.algalog.algalogapi.domain.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private ClientService clientService;

    @Transactional
    public Delivery requestDelivery(Delivery delivery) {
        Client client = clientService.searchClient(delivery.getClient().getId());
        delivery.setClient(client);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setStartDelivery(LocalDateTime.now());
        return deliveryRepository.save(delivery);
    }


}