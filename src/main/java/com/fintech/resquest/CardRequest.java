package com.fintech.resquest;

import com.fintech.CardType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CardRequest {
    private String name;
    private String number;
    private CardType type;
}
