package com.MyCRM.MyCRM.controllers.Implements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.MyCRM.MyCRM.models.Client;
import com.MyCRM.MyCRM.repositories.IClientRepository;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class ClientControllerImpl {

    @Autowired
    private IClientRepository customerRepository;

    @PostMapping
    public Client addCustomer(@RequestBody Client customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Client> getAllCustomers() {
        return customerRepository.findAll();
    }
}
    
    