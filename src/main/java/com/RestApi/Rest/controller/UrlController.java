package com.RestApi.Rest.controller;

import com.RestApi.Rest.model.UrlRequest;
import com.RestApi.Rest.model.UrlResponse;
import com.RestApi.Rest.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("v1/short_url")
    ResponseEntity getShortUrl(@RequestBody(required = true) UrlRequest urlRequest, @RequestHeader (value = "client",required = true)String client ) throws Exception {
        UrlResponse urlResponse = urlService.getShortUrl(urlRequest,client);
        return ResponseEntity.status(HttpStatus.CREATED).body(urlResponse);
    }

    @GetMapping("{hash}")
    ResponseEntity getLongUrl(@PathVariable(required = true)String hash, @RequestHeader (value = "client",required = true)String client ) throws Exception {
        UrlResponse urlResponse = urlService.getLongUrl(hash,client);
        return ResponseEntity.status(HttpStatus.OK).body(urlResponse);
    }


}
