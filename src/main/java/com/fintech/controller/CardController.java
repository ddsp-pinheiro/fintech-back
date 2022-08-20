package com.fintech.controller;

import com.fintech.entity.CardEntity;
import com.fintech.entity.UserAccountEntity;
import com.fintech.mapper.CardMapper;
import com.fintech.mapper.UserMapper;
import com.fintech.response.CardResponse;
import com.fintech.response.UserResponse;
import com.fintech.resquest.CardRequest;
import com.fintech.service.CardService;
import com.fintech.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fintech/card")
@RequiredArgsConstructor
public class CardController {

    private final CardMapper cardMapper;
    private final UserMapper userMapper;
    private final CardService cardService;
    private final UserAccountService userAccountService;

    private static final String CPF = "x-cpf";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardResponse postNewCard(@Valid @RequestBody CardRequest cardRequest,  @RequestHeader(CPF) Long cpf){
        CardEntity entity = cardService.addNewCard(cardMapper.toEntity(cardRequest), cpf);
        return cardMapper.toResponse(entity);
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public CardResponse getCardByNumber(@PathVariable String cardNumber){
        CardEntity entity = cardService.getByNumber(cardNumber);
        return cardMapper.toResponse(entity);
    }
}
