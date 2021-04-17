package com.okta.authentication.controller;

import com.okta.authentication.dto.AuthNRequest;
import com.okta.authentication.dto.AuthNResponse;
import com.okta.authentication.service.AuthNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AuthNController {

    @Autowired
    AuthNService service;

    @GetMapping
    public String getUsers(){
        return "Venkat";
    }

    @PostMapping("/authN")
    public AuthNResponse authentication(@RequestBody AuthNRequest authNRequest){
        return service.authN(authNRequest);
    }



}
