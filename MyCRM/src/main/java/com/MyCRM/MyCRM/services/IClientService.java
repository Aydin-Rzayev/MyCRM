package com.MyCRM.MyCRM.services;



import java.util.List;

import com.MyCRM.MyCRM.models.Client;

public interface IClientService {
    
    public Client saveClient(Client client);

    public List<Client> findAllClients();

    public Boolean existsClient(Client client);

    public Boolean deleteClient(Client client);

}
