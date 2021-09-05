package com.teste.haexagonal.application.port;

import com.teste.haexagonal.application.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer insertCustomer(Customer customerDto);

    void deleteCustomer(Long id);

    List<Customer> listAllCustomer();

    Customer updateCustomer(Customer customer);
}
