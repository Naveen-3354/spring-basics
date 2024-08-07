package com.springBoot.relationships.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springBoot.relationships.models.enums.AddressType;
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int no;
    private String city;
    private String state;
    private String country;
    private int pincode;
    private LocalDate createdOn;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "user_id ")
    @JsonBackReference
    private User user;

    @ManyToMany(mappedBy = "address")
    @JsonIgnoreProperties("address")
    private Set<Orders> orders;


}
