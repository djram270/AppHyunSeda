package com.apirest.apirest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.apirest.apirest.Domain.entity.Client;
import com.apirest.apirest.Domain.service.ClientService;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private  final ClientService clientService;

    @PostMapping
    public void createClient(@RequestBody Client client)
    {        //


        clientService.createClient(client);
    }

    @GetMapping
    public ArrayList<Client> getClients()
    {
           return this.clientService.getClients();
    }

    @GetMapping(path = "/{id}")
    public Optional<Client> getClientById(@PathVariable("id") Integer id)
    {
        return this.clientService.getClientById(id);
    }

    @PutMapping(path = "/{id}")
    public Client updateClientById(@RequestBody Client request,@PathVariable("id") Integer id)
    {
        return this.clientService.updateClientById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteClientById(@PathVariable("id") Integer id)
    {
        boolean ok = this.clientService.deleteClientById(id);

        if(ok)
        {
            return "Se ha eliminado a la persona con id: " + id;
        }
        else
        {
            return "Error, tenemos un problema intentando eliminar a la persona con id: " + id;
        }
    }

}
