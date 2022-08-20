package com.fintech.repository;

import com.fintech.entity.ExpensesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesEntity,Long> {
    List<ExpensesEntity> findAll();
    Optional<ExpensesEntity> findById(Long id);
    Optional<ExpensesEntity> findByTitle(String title);
//    Optional<ExpensesEntity> findByDate(LocalDateTime date);
}
