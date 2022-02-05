package com.RestApi.Rest.service;

import com.RestApi.Rest.entity.Client;
import com.RestApi.Rest.model.ClientRequest;
import com.RestApi.Rest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void onboardClient(final ClientRequest clientRequest) {

        Client client = Client.builder()
                .host(clientRequest.getHost())
                .name(clientRequest.getName())
                .port(clientRequest.getPort())
                .expiryAfterMillis(clientRequest.getExpiryAfterMillis())
                .build();

        clientRepository.save(client);



    }

    @Override
    public Optional<Client> getClient(String name) {

       return clientRepository.findByName(name);

    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }
}
