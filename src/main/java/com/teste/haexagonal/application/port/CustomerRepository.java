package com.teste.haexagonal.application.port;

import com.teste.haexagonal.application.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(Long id);

    void deleteCustomer(Long id);

    Customer updateCustomer(Customer customer);

}
