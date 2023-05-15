package com.algaworks.algalog.algalogapi.controllers;

import com.algaworks.algalog.algalogapi.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @GetMapping
    public List<Client> list(){
        Client client = new Client();
        client.setId(1L);
        client.setName("name");
        client.setEmail("email@email.com");
        client.setTelefone("41-34325987");
        return Arrays.asList(client);
    }

}
