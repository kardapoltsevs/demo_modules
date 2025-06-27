package com.example.confl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ConflController {
    private final RestTemplate restTemplate;
    public ConflController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping("/details/{email}")
    public ResponseEntity<String> getDetails(@PathVariable String email) {

        //Записать логику проверки на наличие email в базе
        String userServiceUrl = "http://user-service/api/users/check-email/" + email;

        // Отправка GET-запроса
        Boolean emailExists = restTemplate.getForObject(userServiceUrl, Boolean.class);

        String response = emailExists
                ? "Email найден. Детали REST API модуля Confl"
                : "Email не найден!";

        return ResponseEntity.ok(response);
    }


}
