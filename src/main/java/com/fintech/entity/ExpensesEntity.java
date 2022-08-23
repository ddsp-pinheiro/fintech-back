package com.fintech.entity;

import com.fintech.PaymentStatus;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "expenses_entity")
public class ExpensesEntity {

    @Id
    @Column(name = "id_expenses")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private LocalDateTime dateCreated;

    @Column
    private LocalDateTime recurrenceDate;

    @Column
    private BigDecimal valor;

    @Column
    private PaymentStatus status;

    @OneToOne
    @JoinColumn(name="id_expenses")
    private PaymentRecipient paymentRecipient;
}
