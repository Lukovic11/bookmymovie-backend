package com.bookmymovie.controller;

import com.bookmymovie.dto.UserDTO;
import com.bookmymovie.entity.User;
import com.bookmymovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Transactional
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping("/byId/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/byEmail/{email}")
    public UserDTO findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/doesUserExist/{email}")
    public boolean doesUserExist(@PathVariable String email) {
        return userService.doesUserExist(email);
    }

    @PostMapping
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/put")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
