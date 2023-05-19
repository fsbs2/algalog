package com.algaworks.algalog.algalogapi.domain.service;

import com.algaworks.algalog.algalogapi.domain.exception.BusinessException;
import com.algaworks.algalog.algalogapi.domain.model.Client;
import com.algaworks.algalog.algalogapi.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrudOperationsClient {
    private final String ERROR_MESSAGE = "Já existe um cliente cadastrado com esse e-mail";
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        boolean emailInUse = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(c -> !c.equals(client));
        if (emailInUse) {
            throw new BusinessException(ERROR_MESSAGE);
        }
        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
