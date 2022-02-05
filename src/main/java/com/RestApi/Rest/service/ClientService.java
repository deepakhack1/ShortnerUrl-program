package com.RestApi.Rest.service;

import com.RestApi.Rest.entity.Client;
import com.RestApi.Rest.model.ClientRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;



public interface ClientService {

    public void onboardClient(final ClientRequest clientRequest);
    Optional<Client> getClient(final String name);
    Client updateClient(Client client);
}
