package com.okta.authentication.service;

import com.okta.authentication.dto.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthNService {
    public  static  final String OKTA_URL="dummy";


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
