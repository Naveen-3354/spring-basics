package com.springBoot.relationships.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springBoot.relationships.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long amount;
    @ManyToOne
    @JoinColumn(name = "user_id ")
    @JsonBackReference
    private User user;

    @ManyToMany(mappedBy = "payment")
    @JsonIgnoreProperties("payment")
    private Set<Orders> orders;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDate createdOn;
}
