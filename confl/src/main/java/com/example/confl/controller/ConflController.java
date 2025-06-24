package com.example.confl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConflController {
    @GetMapping("/details/{email}")
    public ResponseEntity<String> getDetails(@PathVariable String email) {

        //Записать логику проверки на наличие email в базе

        String string = "Детали REST API модуля Confl (GET-запрос)";
        return ResponseEntity.status(200).body(string);
    }
}
