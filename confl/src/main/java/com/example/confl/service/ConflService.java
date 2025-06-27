package com.example.confl.service;

import com.example.confl.model.Confl;
import com.example.confl.repository.ConflRepository;

public class ConflService {
    private final ConflRepository conflRepository;

    public ConflService(ConflRepository conflRepository) {
        this.conflRepository = conflRepository;
    }
    //Добавление почты
    public Confl addEmail(Confl email){

        return conflRepository.save(email);
    }
}
