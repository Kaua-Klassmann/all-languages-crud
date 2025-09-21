package com.example.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(UUID id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public Optional<User> updateUser(UUID id, String name) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            return Optional.empty();
        }

        user.get().setName(name);
        userRepository.save(user.get());

        return user;
    }
}
