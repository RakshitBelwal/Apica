package com.example.apica.service;

import com.example.apica.model.User;
import com.example.apica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "user-events";

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        kafkaTemplate.send(TOPIC, "User saved: " + savedUser.getUsername());
        return savedUser;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        kafkaTemplate.send(TOPIC, "User deleted with id: " + id);
    }
}