package com.practice.usermanagement.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.usermanagement.dtos.LoginDto;
import com.practice.usermanagement.dtos.UserDto;
import com.practice.usermanagement.service.UserAuth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserAuthController {
    
    private final UserAuth userAuth;

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@Valid @RequestBody LoginDto loginDto){
        UserDto userDto = userAuth.loginUser(loginDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }


}
