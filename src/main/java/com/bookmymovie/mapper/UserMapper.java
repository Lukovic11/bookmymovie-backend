package com.bookmymovie.mapper;

import com.bookmymovie.dto.UserDTO;
import com.bookmymovie.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
//    User userDTOToUser(UserDTO userDTO);
    List<UserDTO> toUserDTOs(List<User> users);
}