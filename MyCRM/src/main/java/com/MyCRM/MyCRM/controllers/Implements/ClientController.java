package com.MyCRM.MyCRM.controllers.Implements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MyCRM.MyCRM.models.Client;
import com.MyCRM.MyCRM.repositories.IClientRepository;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private IClientRepository clientRepository;

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
    
    