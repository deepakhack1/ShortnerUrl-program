package com.RestApi.Rest.service;

import com.RestApi.Rest.entity.Client;
import com.RestApi.Rest.entity.Url;
import com.RestApi.Rest.model.UrlRequest;
import com.RestApi.Rest.model.UrlResponse;
import com.RestApi.Rest.repository.UrlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class UrlServiceImpl implements UrlService{

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private ClientService clientService;

    @Override
    public UrlResponse getShortUrl(final UrlRequest urlRequest,String clientname) throws Exception {

        //System.out.println("hi");
      Client client =  clientService.getClient(clientname).orElseThrow(()->new Exception("unknown client"));
        System.out.println("client name :"+client);
      Url url = Url.builder()
                .longUrl(urlRequest.getLongUrl()).build();
        System.out.println("hi");
        url = urlRepository.save(url);

        client.getUrlList().add(url);
        clientService.updateClient(client);
        Long id = url.getId();
        String encodedId = Base64.getEncoder().encodeToString(String.valueOf(id).getBytes());

        return UrlResponse.builder().url("http://"+client.getHost()+":"+client.getPort()+"/"+ encodedId).build();
    }


    @Override
    public UrlResponse getLongUrl(String encrytedId, String clientId) throws Exception {
       String idString = new String(Base64.getDecoder().decode(encrytedId),"UTF-8");
       Long id = Long.decode(idString);
       Url url = urlRepository.findById(id).orElseThrow(()->new Exception("no such url"));
       return UrlResponse.builder().url(url.getLongUrl()).build();
    }



}
