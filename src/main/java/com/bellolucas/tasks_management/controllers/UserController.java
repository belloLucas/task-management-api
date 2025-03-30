package com.bellolucas.tasks_management.controllers;

import com.bellolucas.tasks_management.dto.user.CreateUserDTO;
import com.bellolucas.tasks_management.entities.user.User;
import com.bellolucas.tasks_management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody @Valid CreateUserDTO data) {
        return userService.createUser(data);
    }
}
