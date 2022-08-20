package com.fintech.entity;

import com.fintech.CardType;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "card_entity")
public class CardEntity {
    @Id
    @Column(name = "id_card")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @Size(max = 16)
    private String number;

    @Column
    private CardType type;

    @Column
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name="debit")
    @OneToMany
    @JoinTable(name="expenses_entity",
            joinColumns={@JoinColumn(name="id_expenses")},
            inverseJoinColumns={@JoinColumn(name="debit")})
    @Builder.Default
    private List<ExpensesEntity> debit = null;
}
