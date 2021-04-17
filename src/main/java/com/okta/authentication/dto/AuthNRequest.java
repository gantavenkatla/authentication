package com.okta.authentication.dto;

import lombok.Data;

@Data
public class AuthNRequest {
    private String username;
    private  String password;
}
