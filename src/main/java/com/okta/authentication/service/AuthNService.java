package com.okta.authentication.service;

import com.okta.authentication.dto.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class AuthNService {
    
  @Value("${okta.endpoint}")
  private String OKTA_URL;


    public AuthNResponse authN(AuthNRequest authNRequest){

        HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthNRequest> entity = new HttpEntity<AuthNRequest>(authNRequest,httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AuthNResponse> loginResponse= restTemplate.exchange(OKTA_URL, HttpMethod.POST,entity,AuthNResponse.class);

        AuthNResponse authNResponse = loginResponse.getBody()!=null ?loginResponse.getBody() : null;
        authNResponse.setName("Ganta"); // to load extra data either from db or call from other service

        return  authNResponse;

    }
}
