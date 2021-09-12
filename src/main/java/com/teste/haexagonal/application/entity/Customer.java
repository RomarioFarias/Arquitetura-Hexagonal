package com.teste.haexagonal.application.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_CUSTOMER")
@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String birthDate;

    public Customer(String xzx, String sadas) {
    }
}
