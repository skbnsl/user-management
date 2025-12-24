package com.practice.usermanagement.service;

import com.practice.usermanagement.dtos.LoginDto;
import com.practice.usermanagement.dtos.UserDto;

public interface UserAuth {

    UserDto loginUser(LoginDto loginDto);

}
