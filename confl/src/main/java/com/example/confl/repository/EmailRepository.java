package com.example.confl.repository;

import com.example.confl.model.Confl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Confl, Long> {
    boolean existsByEmail(String email);
}
