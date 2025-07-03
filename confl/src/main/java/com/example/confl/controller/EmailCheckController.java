package com.example.confl.controller;

import com.example.confl.model.Confl;
import com.example.confl.service.ConflService;
import com.example.confl.service.EmailCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailCheckController {
    private ConflService conflService;
    @Autowired
    private EmailCheckService emailCheckService;
    public ResponseEntity<?> checkEmail(@RequestParam String email) {
        boolean isAvailable = emailCheckService.isEmailAvailable(email);
        if(isAvailable) {
            Confl newEmail = new Confl();
            newEmail.setEmail(email); // Устанавливаем email
            saveEmail(newEmail); // Передаем объект с email
        }
        return ResponseEntity.ok().body(Map.of("available", isAvailable));
    }
    public Confl saveEmail(Confl email) {
        return conflService.addEmail(email);
    }
}
