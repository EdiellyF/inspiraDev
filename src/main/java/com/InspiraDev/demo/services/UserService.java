package com.InspiraDev.demo.services;

import com.InspiraDev.demo.models.User;
import com.InspiraDev.demo.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
