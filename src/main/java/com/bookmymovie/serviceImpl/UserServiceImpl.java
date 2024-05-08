package com.bookmymovie.serviceImpl;

import com.bookmymovie.repository.UserRepository;
import com.bookmymovie.dto.UserDTO;
import com.bookmymovie.entity.User;
import com.bookmymovie.mapper.UserMapper;
import com.bookmymovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public void update(User user) {
        User old =userRepository.findById(user.getId()).orElseThrow();
        user.setPassword(old.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userMapper.userToUserDTO(userRepository.findByEmail(email).orElseThrow());

    }
}
