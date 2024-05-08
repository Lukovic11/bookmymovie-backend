package com.bookmymovie.service;

import com.bookmymovie.dto.UserDTO;
import com.bookmymovie.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    void save(User user);

    void update(User user);

    void deleteById(Long id);

    UserDTO findByEmail(String email);
}
