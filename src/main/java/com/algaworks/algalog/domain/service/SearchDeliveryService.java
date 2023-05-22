package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.exception.EntityNotFoundException;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchDeliveryService {
    DeliveryRepository deliveryRepository;

    public Delivery search(Long id) {
        return deliveryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Delivery not found"));
    }
}
