package com.MyCRM.MyCRM.controllers.Implements;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyCRM.MyCRM.models.Client;
import com.MyCRM.MyCRM.services.Implements.ClientServiceImpl;
import com.MyCRM.MyCRM.controllers.IClientController;

@RestController
@RequestMapping(path = "/client")
public class ClientControllerImpl implements IClientController {
    private ClientServiceImpl clientService;

    @GetMapping(path = "/all")
    @Override
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @PostMapping(path = "/add")
    @Override
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        if(clientService.existsClient(client)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(client);
        }
        else{
            return ResponseEntity.ok(clientService.saveClient(client));
        }
    }

    @DeleteMapping(path = "/delete")
    @Override
    public ResponseEntity<Boolean> deleteClient(@RequestBody Client client){
        if(!clientService.existsClient(client)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.ok(clientService.deleteClient(client));
        }
    }
}
