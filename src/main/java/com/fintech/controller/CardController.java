package com.fintech.controller;

import com.fintech.entity.CardEntity;
import com.fintech.mapper.CardMapper;
import com.fintech.response.CardResponse;
import com.fintech.resquest.CardRequest;
import com.fintech.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/fintech/card")
@RequiredArgsConstructor
public class CardController {

    private final CardMapper cardMapper;
    private final CardService cardService;

    private static final String CPF = "x-cpf";
    private static final String ID = "x-id";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardResponse postNewCard(@Valid @RequestBody CardRequest cardRequest,  @RequestHeader(CPF) Long cpf){
        CardEntity entity = cardService.addNewCard(cardMapper.toEntity(cardRequest), cpf);
        return cardMapper.toResponse(entity);
    }

    @GetMapping("/{cardNumber}")
    @ResponseStatus(HttpStatus.OK)
    public CardResponse getCardByNumber(@PathVariable String cardNumber){
        CardEntity entity = cardService.getByNumber(cardNumber);
        return cardMapper.toResponse(entity);
    }

    @GetMapping("myCards")
    @ResponseStatus(HttpStatus.OK)
    public List<CardEntity> getAllCardFromUser(@RequestHeader(ID) Long id){
        List<CardEntity> entity = cardService.getCards(id);

        return entity;
    }
}
