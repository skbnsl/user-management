package com.practice.usermanagement.controllers;

import com.practice.usermanagement.dtos.UserDto;
import com.practice.usermanagement.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

        @PostMapping("/add")
        public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userdto){
            UserDto addedUser = userService.addUser(userdto);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
        }

        @GetMapping("/find/{userId}")
        public ResponseEntity<UserDto> getUser(@Valid @RequestParam Long userId){
            UserDto addedUser = userService.getUser(userId);
            return ResponseEntity.status(HttpStatus.OK).body(addedUser);
        }

        @PostMapping("/delete/{userId}")
        public ResponseEntity deleteUser(@Valid @RequestParam Long userId){
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

}
