package com.example.user.service;

import com.example.user.model.User;
import com.example.user.model.UserBody;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}
    @Autowired
    public List<User> getAllUsers() { return userRepository.findAll();}
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Autowired
    private RestTemplate restTemplate;
    public ResponseEntity<?> createUser(User newUser) {
        // Запрос к модулю confl для проверки email
        String checkUrl = "http://localhost:8081/api/email/check?email=" + newUser.getEmail();
        ResponseEntity<Map> response = restTemplate.getForEntity(checkUrl, Map.class);
        if (Boolean.TRUE.equals(response.getBody().get("available"))) {
            User savedUser = userRepository.save(newUser);
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.badRequest().body("Такой email уже зарегистрирован");
        }
    }
}
