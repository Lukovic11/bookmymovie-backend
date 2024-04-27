package com.bookmymovie.serviceImpl;

import com.bookmymovie.repository.UserRepository;
import com.bookmymovie.dto.UserDTO;
import com.bookmymovie.entity.User;
import com.bookmymovie.mapper.UserMapper;
import com.bookmymovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        return userMapper.userToUserDTO(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findByEmail(String email) {
//        User user=userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow();
//        return userMapper.userToUserDTO(user);
        return userMapper.userToUserDTO(userRepository.findByEmail(email).orElseThrow());

    }
}
