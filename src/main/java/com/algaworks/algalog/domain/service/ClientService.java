package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
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

    public Client searchClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new BusinessException("client not exist"));
    }
}
