package com.fintech.mapper;

import com.fintech.entity.CardEntity;
import com.fintech.entity.UserAccountEntity;
import com.fintech.response.UserResponse;
import com.fintech.resquest.UserRequest;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

     public UserResponse toResponse(UserAccountEntity userAccountEntity){
         return UserResponse.builder()
                 .id(userAccountEntity.getId())
                 .name(userAccountEntity.getName())
                 .balance(userAccountEntity.getBalance())
                 .cpf(userAccountEntity.getCpf())
                 .cards(userAccountEntity.getCards().stream()
                         .map(cardEntity -> CardEntity.builder()
                                 .id(cardEntity.getId())
                                 .number(cardEntity.getNumber())
                                 .name(cardEntity.getName())
                                 .type(cardEntity.getType())
                                 .balance(cardEntity.getBalance())
                                 .debit(cardEntity.getDebit())
                                 .build()).collect(Collectors.toList()))
                 .totalDebitBalance(userAccountEntity.getTotalDebitBalance())
                 .build();
     }

    public UserAccountEntity toEntity(UserRequest userRequest){
         return UserAccountEntity.builder().name(userRequest.getName())
                 .cpf(userRequest.getCpf())
                 .build();
    }

}
