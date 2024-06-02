package com.apirest.apirest.Domain.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.apirest.Domain.entity.Client;
import com.apirest.apirest.repository.iClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final  iClientRepository clientRepo;
    /**
     * Creates a new client.
     *
     * @param client The client object to be created.
     */
    public void createClient(Client client)
    {
        clientRepo.save(client);
    }
    /**
     * Retrieves all clients.
     *
     * @return An ArrayList containing all clients.
     */
    public ArrayList<Client> getClients()
    {
        return (ArrayList<Client>) clientRepo.findAll();
    }
    /**
     * Retrieves a client by its ID.
     *
     * @param id The ID of the client to retrieve.
     * @return An Optional containing the client if found, otherwise empty.
     */
    public Optional<Client> getClientById(Integer id)
    {
        return clientRepo.findById(id);
    }
    /**
     * Updates an existing client by ID.
     *
     * @param request The updated client object.
     * @param id The ID of the client to update.
     * @return The updated client object.
     */
    public Client updateClientById(Client request, Integer id)
    {
        Client client = clientRepo.findById(id).get();

        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setAddress(request.getAddress());

        return client;
    }
    /**
     * Deletes a client by its ID.
     *
     * @param id The ID of the client to delete.
     * @return true if deletion is successful, false otherwise.
     */
    public Boolean deleteClientById(Integer id)
    {
        try
        {
            clientRepo.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
