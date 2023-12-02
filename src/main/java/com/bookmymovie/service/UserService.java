package com.bookmymovie.service;

import com.bookmymovie.dto.UserDTO;
import com.bookmymovie.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    void save(User user);

    void deleteById(Long id);
}
