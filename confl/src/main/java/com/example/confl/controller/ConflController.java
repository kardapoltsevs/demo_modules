package com.example.confl.controller;

import com.example.confl.model.Confl;
import com.example.confl.service.ConflService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/email")
@RequiredArgsConstructor
public class ConflController {
    @Autowired
    private ConflService conflService;
    @GetMapping
    public List<Confl> getAllEmails() {
        return conflService.getAllEmails();
    }
}
