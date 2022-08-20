package com.fintech.response;

import com.fintech.entity.CardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private Long cpf;
    private List<CardEntity> cards;
    private BigDecimal balance;
    private BigDecimal totalDebitBalance;
}
