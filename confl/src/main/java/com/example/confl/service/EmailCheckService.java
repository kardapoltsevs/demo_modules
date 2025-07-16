package com.example.confl.service;

import com.example.confl.repository.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailCheckService {
    private EmailRepository emailRepository;

    public EmailCheckService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }
    public boolean isEmailAvailable(String email){
        return !emailRepository.existsByEmail(email);
    }
}
