package com.bellolucas.tasks_management.services;

import com.bellolucas.tasks_management.dto.user.CreateUserDTO;
import com.bellolucas.tasks_management.entities.user.User;
import com.bellolucas.tasks_management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(CreateUserDTO data) {
        String encodedPassword = passwordEncoder.encode(data.password());

        User user = new User(data, encodedPassword);
        return userRepository.save(user);
    }

    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
