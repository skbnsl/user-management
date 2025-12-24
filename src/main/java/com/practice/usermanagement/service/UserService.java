package com.practice.usermanagement.service;

import com.practice.usermanagement.dtos.UserDto;

import jakarta.validation.Valid;

public interface UserService {

    UserDto addUser(UserDto user);

    UserDto getUser(Long userId);

    void deleteUser(Long userId);

}
