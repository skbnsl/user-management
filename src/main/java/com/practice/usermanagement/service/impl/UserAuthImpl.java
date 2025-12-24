package com.practice.usermanagement.service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.usermanagement.dtos.LoginDto;
import com.practice.usermanagement.dtos.UserDto;
import com.practice.usermanagement.entity.User;
import com.practice.usermanagement.mapper.UserMapper;
import com.practice.usermanagement.repository.UserRepository;
import com.practice.usermanagement.service.UserAuth;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthImpl implements UserAuth {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto loginUser(LoginDto loginDto) {
        User user = userRepository.getByEmail(loginDto.getEmail());
        if(user==null){
            throw new UsernameNotFoundException("user not exist");
        }
        boolean isPasswordMatch = passwordEncoder.matches(
            loginDto.getPassword().trim(), // raw password
            user.getPassword()              // encoded password from DB
        );
        if (!isPasswordMatch) {
            throw new BadCredentialsException("Invalid credentials");
        }
        return userMapper.toDto(user); 
    }
    
}
