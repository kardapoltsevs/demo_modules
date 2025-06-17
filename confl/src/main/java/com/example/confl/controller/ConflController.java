package com.example.confl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConflController {
    @GetMapping("/details")
    public String getDetails() {
        return "Детали REST API модуля Confl (GET-запрос)";
    }
}
