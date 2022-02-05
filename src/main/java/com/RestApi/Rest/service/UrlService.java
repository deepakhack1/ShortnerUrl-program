package com.RestApi.Rest.service;

import com.RestApi.Rest.entity.Client;
import com.RestApi.Rest.model.UrlRequest;
import com.RestApi.Rest.model.UrlResponse;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;



public interface UrlService {

    public UrlResponse getShortUrl(UrlRequest urlRequest, String clientId) throws Exception;

    public UrlResponse getLongUrl(final String encrytedId,String clientId) throws Exception;
}
