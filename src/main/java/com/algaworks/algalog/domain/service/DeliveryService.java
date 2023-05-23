package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.api.dto.request.OccurenceInput;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.DeliveryStatus;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;
    private ClientService clientService;

    private SearchDeliveryService searchDeliveryService;

    private OccurenceRegistryService occurenceRegistryService;

    @Transactional
    public Delivery requestDelivery(Delivery delivery) {
        Client client = clientService.searchClient(delivery.getClient().getId());
        delivery.setClient(client);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setStartDelivery(OffsetDateTime.now());
        return deliveryRepository.save(delivery);
    }

    @Transactional
    public void finish(Long id) {
        Delivery delivery = searchDeliveryService.search(id);
        delivery.finalizeDelivery();
        deliveryRepository.save(delivery);
    }

    @Transactional
    public void cancel(Long id, OccurenceInput occurenceInput) {
        occurenceRegistryService.registry(id,occurenceInput.getDescription());
        Delivery delivery = deliveryRepository.findById(id).get();
        delivery.cancelDelivery();
        deliveryRepository.save(delivery);
    }
}
