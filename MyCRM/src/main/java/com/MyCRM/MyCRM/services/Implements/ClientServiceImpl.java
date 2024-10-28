package com.MyCRM.MyCRM.services.Implements;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyCRM.MyCRM.models.Client;
import com.MyCRM.MyCRM.repositories.IClientRepository;
import com.MyCRM.MyCRM.services.IClientService;


@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findAllClients(){
        return (List<Client>)clientRepository.findAll();
    }

    public Boolean existsClient(Client client){
        return clientRepository.findAll().contains(client);
    }

    @Override
    public Boolean deleteClient(Client client){
        if(existsClient(client)){
            clientRepository.delete(client);
            return true;
        }
        return false;
    }
   
}

