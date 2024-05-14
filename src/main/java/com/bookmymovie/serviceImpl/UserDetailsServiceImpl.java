package com.bookmymovie.serviceImpl;

import com.bookmymovie.exceptions.BadRequestException;
import com.bookmymovie.exceptions.NotFoundException;
import com.bookmymovie.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        if(username==null){
            throw new BadRequestException("Username cannot be null.");
        }
        return repository.findByEmail(username)
                .orElseThrow(()->new NotFoundException("User with the username of "+username+" not found."));
    }
}
