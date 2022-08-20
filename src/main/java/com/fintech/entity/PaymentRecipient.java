package com.fintech.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "payment_recipient_entity")
public class PaymentRecipient {

    @Id
    @Column(name = "id_recipient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String accountNumber;

    @Column
    private Long bankBranch;
}
