package com.bookmymovie.serviceImpl;

import com.bookmymovie.dto.AuthenticationResponse;
import com.bookmymovie.entity.User;
import com.bookmymovie.exceptions.NotFoundException;
import com.bookmymovie.exceptions.ValidationException;
import com.bookmymovie.repository.UserRepository;
import com.bookmymovie.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private UserService userService;

    public AuthenticationResponse register(User request){
        if(userService.doesUserExist(request.getEmail())){
            throw new ValidationException("User with "+request.getEmail()+" email already exists");
        }

        if(request.getPassword().length()<8){
            throw new ValidationException("Password must be at least 8 characters long.");
        }
        if(request.getFirstname()==null || request.getLastname()==null ||
        request.getEmail()==null){
            throw new ValidationException("User data cannot be empty.");
        }

        User user=new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(request.getRole());

        user=repository.save(user);

        String token=jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
    public AuthenticationResponse authenticate(User request){
        if(!(userService.doesUserExist(request.getEmail()))){
            throw new NotFoundException("User with email "+request.getEmail()+" not found");
        }
        if(request.getEmail()==null || request.getPassword()==null){
            throw new ValidationException("User data cannot be empty.");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user=repository.findByEmail(request.getEmail()).orElseThrow();
        String token=jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

}
