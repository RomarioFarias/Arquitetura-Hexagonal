package com.teste.haexagonal.template;

import com.teste.haexagonal.adapters.inbound.CustomerDto;
import com.teste.haexagonal.application.entity.Customer;

import java.util.List;

public class CustomerTestTemplate {

    public final static String NAME = "Teste";
    public final static String BIRTH_DATE = "12/12/1994";
    public final static String ID = "1";


    public static Customer getCustomerTemplate() {
        return new Customer().withId(Long.valueOf(ID))
                .withBirthDate(BIRTH_DATE)
                .withName(NAME);
    }

    public static List<Customer> getListCustomerTemplate() {
        return List.of(getCustomerTemplate());
    }

    public static CustomerDto getCustomerDtoTemplate() {
        return new CustomerDto().withBirthDate(BIRTH_DATE)
                .withName(NAME);
    }
}
