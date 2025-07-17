package com.hparser.hparser.DTOs;

import lombok.Data;

@Data
public class JwtRequestDto {
    private String username;
    private String password;
}
