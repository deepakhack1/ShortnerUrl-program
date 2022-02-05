package com.RestApi.Rest.controller;

import com.RestApi.Rest.model.ClientRequest;
import com.RestApi.Rest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired(required = true)
    private ClientService clientService;

    @PostMapping("v1/client")
    void onBoard(@RequestBody ClientRequest clientRequest)
    {

        clientService.onboardClient(clientRequest);
    }
}
