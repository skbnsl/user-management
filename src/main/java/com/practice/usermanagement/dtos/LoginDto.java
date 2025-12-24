package com.practice.usermanagement.dtos;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    
    @Email
    private String email;
    private String password;

}
