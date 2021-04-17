package com.okta.authentication.dto;

import lombok.Data;

@Data
public class AuthNResponse {
    private String stateToken;
    private String status;
    private String name;

}
