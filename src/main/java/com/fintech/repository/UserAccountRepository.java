package com.fintech.repository;

import com.fintech.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Long> {
    Optional<UserAccountEntity> findById(Long id);
    Optional<UserAccountEntity> findByCpf(Long accountNumber);
}
