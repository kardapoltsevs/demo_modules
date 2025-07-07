package com.example.confl.service;

import com.example.confl.model.Confl;
import com.example.confl.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConflService {
    private final EmailRepository conflRepository;


    public ConflService(EmailRepository conflRepository) {
        this.conflRepository = conflRepository;
    }
    //Добавление почты
    public Confl addEmail(Confl email){

        return conflRepository.save(email);
    }
    public List<Confl> getAllEmails() {
        return conflRepository.findAll();
    }
}
