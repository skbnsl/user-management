package com.practice.usermanagement.mapper;

import org.mapstruct.Mapper;

import com.practice.usermanagement.dtos.UserDto;
import com.practice.usermanagement.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

}