package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.DeliveryStatus;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

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
        delivery.setStartDelivery(OffsetDateTime.now());
        return deliveryRepository.save(delivery);
    }


}
