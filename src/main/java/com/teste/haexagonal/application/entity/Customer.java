package com.teste.haexagonal.application.entity;


import javax.persistence.*;

@Entity
@Table(name = "TB_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String birthDate;
}
