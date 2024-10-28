package com.MyCRM.MyCRM.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.MyCRM.MyCRM.models.Client;

public interface IClientController {
    public ResponseEntity<Client> addClient(Client user);

    public ResponseEntity<List<Client>> getAllClients();

    public ResponseEntity<Boolean> deleteClient(Client client);
}
