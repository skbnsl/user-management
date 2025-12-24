package com.practice.usermanagement.service.impl;


import com.practice.usermanagement.dtos.UserDto;
import com.practice.usermanagement.entity.User;
import com.practice.usermanagement.exceptions.UserAlreadyExistsException;
import com.practice.usermanagement.mapper.UserMapper;
import com.practice.usermanagement.repository.UserRepository;
import com.practice.usermanagement.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;    
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto addUser(UserDto userdto) { 
        String email = userdto.getEmail();
        Boolean exist = userRepository.existsByEmail(email);

        if(exist){
            //throw new RuntimeException("user already exist!");
            throw new UserAlreadyExistsException("user already exist!");
        }

        User user = userMapper.toEntity(userdto);
        
        user.setPassword(passwordEncoder.encode(userdto.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user==null){
            throw new UsernameNotFoundException("user not found with userId "+ userId);
        }
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user==null){
            throw new UsernameNotFoundException("user not found with userId "+ userId);
        }
        userRepository.deleteById(userId);
    }
}
