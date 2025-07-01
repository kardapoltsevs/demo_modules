package com.example.confl.controller;

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
    @Autowired
    private EmailCheckService emailCheckService;
    public ResponseEntity<?> checkEmail(@RequestParam String email) {
        boolean isAvailable = emailCheckService.isEmailAvailable(email);
        return ResponseEntity.ok().body(Map.of("available", isAvailable));
    }
}
