package com.fintech.mapper;

import com.fintech.entity.CardEntity;
import com.fintech.entity.ExpensesEntity;
import com.fintech.response.CardResponse;
import com.fintech.resquest.CardRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapper {


    public CardResponse toResponse(CardEntity cardEntity){
        return CardResponse.builder()
                .id(cardEntity.getId())
                .type(cardEntity.getType())
                .balance(cardEntity.getBalance())
                .name(cardEntity.getName())
                .number(cardEntity.getNumber())
                .debit(cardEntity.getDebit().stream()
                        .map(expensesEntity -> ExpensesEntity.builder()
                        .id(expensesEntity.getId())
                        .dateCreated(expensesEntity.getDateCreated())
                        .paymentRecipient(expensesEntity.getPaymentRecipient())
                        .recurrenceDate(expensesEntity.getRecurrenceDate())
                        .status(expensesEntity.getStatus())
                        .title(expensesEntity.getTitle())
                        .valor(expensesEntity.getValor()).build())
                        .collect(Collectors.toList()))
                .build();
    }

    public List<CardResponse> toResponseList(CardEntity cardEntity){
        return List.of(CardResponse.builder()
                .id(cardEntity.getId())
                .type(cardEntity.getType())
                .balance(cardEntity.getBalance())
                .name(cardEntity.getName())
                .number(cardEntity.getNumber())
                .debit(cardEntity.getDebit().stream()
                        .map(expensesEntity -> ExpensesEntity.builder()
                                .id(expensesEntity.getId())
                                .dateCreated(expensesEntity.getDateCreated())
                                .paymentRecipient(expensesEntity.getPaymentRecipient())
                                .recurrenceDate(expensesEntity.getRecurrenceDate())
                                .status(expensesEntity.getStatus())
                                .title(expensesEntity.getTitle())
                                .valor(expensesEntity.getValor()).build())
                        .collect(Collectors.toList()))
                .build());
    }

    public CardEntity toEntity(CardRequest cardRequest){
        return CardEntity.builder()
                .type(cardRequest.getType())
                .name(cardRequest.getName())
                .number(cardRequest.getNumber())
                .build();
    }

    public List<CardEntity> toEntityList(CardRequest cardRequest){
        return List.of(CardEntity.builder()
                .type(cardRequest.getType())
                .name(cardRequest.getName())
                .number(cardRequest.getNumber())
                .build());
    }

}
