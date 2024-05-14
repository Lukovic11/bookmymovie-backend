package com.bookmymovie.serviceImpl;

import com.bookmymovie.exceptions.BadRequestException;
import com.bookmymovie.exceptions.NotFoundException;
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
        if(id==null){
            throw new BadRequestException("User id cannot be null.");
        }
        return userMapper.userToUserDTO(userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("User with the id of "+id+" not found.")));
    }

    @Override
    public void save(User user) {
        if(user==null){
            throw new BadRequestException("User cannot be null.");
        }
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        if(user==null){
            throw new BadRequestException("User cannot be null.");
        }
        if(user.getRole()=="admin"){
            throw new BadRequestException("This user is already an admin.");
        }
        User old =userRepository.findById(user.getId())
                .orElseThrow(()->new NotFoundException("User with the id of "+user.getId()+" not found."));
        user.setPassword(old.getPassword());
        user.setRole("admin");
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        if(id==null){
            throw new BadRequestException("User id cannot be null.");
        }
        userRepository.findById(id)
                .orElseThrow(()->new NotFoundException("User with the id of "+id+" not found."));
        userRepository.deleteById(id);
    }

    @Override
    public boolean doesUserExist(String email) {
        if(email==null){
            throw new BadRequestException("User email cannot be null.");
        }
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDTO findByEmail(String email) {
        if(email==null){
            throw new BadRequestException("User email cannot be null.");
        }
        userRepository.findByEmail(email)
                .orElseThrow(()->new NotFoundException("User with the email of "+email+" not found."));
        return userMapper.userToUserDTO(userRepository.findByEmail(email).orElseThrow());

    }
}
