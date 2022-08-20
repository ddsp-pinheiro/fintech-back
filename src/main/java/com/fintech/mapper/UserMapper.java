package com.fintech.mapper;

import com.fintech.entity.UserAccountEntity;
import com.fintech.response.UserResponse;
import com.fintech.resquest.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

     public UserResponse toResponse(UserAccountEntity userAccountEntity){
         return UserResponse.builder().name(userAccountEntity.getName())
                 .id(userAccountEntity.getId())
                 .balance(userAccountEntity.getBalance())
                 .cpf(userAccountEntity.getCpf())
                 .cards(userAccountEntity.getCards())
                 .totalDebitBalance(userAccountEntity.getTotalDebitBalance())
                 .build();
     }

    public UserAccountEntity toEntity(UserRequest userRequest){
         return UserAccountEntity.builder().name(userRequest.getName())
                 .cpf(userRequest.getCpf())
                 .build();
    }

}
