package com.example.confl.service;

import com.example.confl.model.Confl;
import com.example.confl.repository.EmailRepository;

public class ConflService {
    private final EmailRepository conflRepository;

    public ConflService(EmailRepository conflRepository) {
        this.conflRepository = conflRepository;
    }
    //Добавление почты
    public Confl addEmail(Confl email){

        return conflRepository.save(email);
    }
}
