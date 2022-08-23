package com.fintech.response;

import com.fintech.CardType;
import com.fintech.entity.ExpensesEntity;
import com.fintech.entity.UserAccountEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class CardResponse {

    private Long id;
//    private UserAccountEntity userAccountEntity;
    private String name;
    private String number;
    private CardType type;
    private BigDecimal balance;
    private List<ExpensesEntity> debit;
}
