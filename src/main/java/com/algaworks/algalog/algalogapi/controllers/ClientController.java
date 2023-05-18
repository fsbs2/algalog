package com.algaworks.algalog.algalogapi.controllers;

import com.algaworks.algalog.algalogapi.domain.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<Client> list() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}
