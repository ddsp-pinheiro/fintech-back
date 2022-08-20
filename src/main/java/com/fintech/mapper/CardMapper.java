package com.fintech.mapper;

import com.fintech.entity.CardEntity;
import com.fintech.entity.UserAccountEntity;
import com.fintech.response.CardResponse;
import com.fintech.response.UserResponse;
import com.fintech.resquest.CardRequest;
import com.fintech.resquest.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    public CardResponse toResponse(CardEntity cardEntity){
        return CardResponse.builder()
                .id(cardEntity.getId())
                .type(cardEntity.getType())
                .balance(cardEntity.getBalance())
                .name(cardEntity.getName())
                .number(cardEntity.getNumber())
                .debit(cardEntity.getDebit())
                .build();
    }

    public CardEntity toEntity(CardRequest cardRequest){
        return CardEntity.builder()
                .type(cardRequest.getType())
                .name(cardRequest.getName())
                .number(cardRequest.getNumber())
                .build();
    }

}
