package com.teste.haexagonal.application.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_CUSTOMER")
@With
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


    @Override
    public String toString(){
        return "nome =" +getName();
    }

}
