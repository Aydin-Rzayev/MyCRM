package com.MyCRM.MyCRM.services.Implements;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyCRM.MyCRM.models.Client;
import com.MyCRM.MyCRM.repositories.IClientRepository;
import com.MyCRM.MyCRM.services.IClientService;


@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public Client findClientByContactName(String name){
        Iterator<Client> clients = clientRepository.findAll().iterator();
        Optional<Client> clientsOptional = Optional.empty();
        while(clients.hasNext()){
            Client client = clients.next();
            if(client.getContactName().equalsIgnoreCase(name)){
                clientsOptional = Optional.of(client);
            }
        }
        return clientsOptional.get();
    }

    public Client findClientByCompanyName(String name){
        Iterator<Client> clients = clientRepository.findAll().iterator();
        Optional<Client> clientsOptional = Optional.empty();
        while(clients.hasNext()){
            Client client = clients.next();
            if(client.getCompanyName().equalsIgnoreCase(name)){
                clientsOptional = Optional.of(client);
            }
        }
        return clientsOptional.get();
    }

    public Client findClientByPhoneNumber(Long phoneLong){
        Iterator<Client> clients = clientRepository.findAll().iterator();
        Optional<Client> clientsOptional = Optional.empty();
        while(clients.hasNext()){
            Client client = clients.next();
            if(client.getPhoneNumber() == phoneLong){
                clientsOptional = Optional.of(client);
            }
        }
        return clientsOptional.get();
    }

    public Optional<Client> findClientsById(Integer Id){
        return clientRepository.findById(Id);
    }

    public List<Client> findAllClients(){
        return (List<Client>)clientRepository.findAll();
    }

    public Boolean existsClient(Client client){
        return clientRepository.findAll().equals(client);
    }

    public Boolean deleteUser(Client client){
        if(existsClient(client)){
            clientRepository.delete(client);
            return true;
        }
        return false;
    }
    //findclient by company name, phone number etc



    
   
}

