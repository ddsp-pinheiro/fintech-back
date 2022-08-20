package com.fintech.service;

import com.fintech.entity.UserAccountEntity;
import com.fintech.exception.NotFoundException;
import com.fintech.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private static final String CPF_NOT_FOUND = "Account number not found";

    private final UserAccountRepository userAccountRepository;

    public UserAccountEntity addUser(UserAccountEntity userAccountEntity){
        if (userAccountRepository.findByCpf(userAccountEntity.getCpf()).isPresent()){
            throw new DuplicateKeyException("This user already exists");
        }
        if (!verifyCpf(userAccountEntity.getCpf())){
            throw new RuntimeException("The cpf entered is invalid");
        }
        return userAccountRepository.save(userAccountEntity);
    }

    private Boolean verifyCpf(Long cpf){
        return cpf > 10000000000L && cpf < 99999999999L;
    }

    public UserAccountEntity updateUser(UserAccountEntity userAccountEntity){
        return userAccountRepository.save(userAccountEntity);
    }

    public UserAccountEntity getByCpf(Long cpf){
        return userAccountRepository.findByCpf(cpf).orElseThrow(() -> new NotFoundException(CPF_NOT_FOUND));
    }
}
