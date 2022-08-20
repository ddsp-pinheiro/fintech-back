package com.fintech.repository;

import com.fintech.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity,Long> {
    List<CardEntity> findAll();
    Optional<CardEntity> findById(Long id);
    Optional<CardEntity> findByNumber(String number);
}
