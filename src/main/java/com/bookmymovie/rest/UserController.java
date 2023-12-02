package com.bookmymovie.rest;

import com.bookmymovie.dto.UserDTO;
import com.bookmymovie.entity.User;
import com.bookmymovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @Transactional
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping("/byId/{id}")
    @Transactional
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @Transactional
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
