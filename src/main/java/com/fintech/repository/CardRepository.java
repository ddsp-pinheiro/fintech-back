package com.fintech.repository;

import com.fintech.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity,Long> {
    Optional<CardEntity> findById(Long id);
    Optional<CardEntity> findByNumber(String number);

    @Query(value = "SELECT * FROM fintech.card_entity c WHERE c.id_user= :id",
            nativeQuery = true)
    List<CardEntity> findAllByUser(@Param("id") Long id);
}
