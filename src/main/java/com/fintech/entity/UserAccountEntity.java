package com.fintech.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_account_entity")
public class UserAccountEntity {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Long cpf;

    @Column(name="cards")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_user")
    @Builder.Default
    private List<CardEntity> cards = new ArrayList<>();

    @Column
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;

    @Column
    @Builder.Default
    private BigDecimal totalDebitBalance = BigDecimal.ZERO;
}
