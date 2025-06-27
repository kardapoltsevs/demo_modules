package com.example.confl.repository;

import com.example.confl.model.Confl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConflRepository extends JpaRepository<Confl, Long> {
}
