package com.teste.haexagonal.application.service;

import com.teste.haexagonal.adapters.inbound.CustomerDto;
import com.teste.haexagonal.adapters.inbound.CustomerMapper;
import com.teste.haexagonal.application.entity.Customer;
import com.teste.haexagonal.application.port.CustomerRepository;
import com.teste.haexagonal.application.port.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;


@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private  CustomerRepository customerRepository;
    private  CustomerMapper customerMapper;


    @Override
    public Customer insertCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    private Customer convertCostumer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setBirthDate(customerDto.getBirthDate());

        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        this.customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> listAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer updateCustomer(Customer customer) {
        return this.customerRepository.updateCustomer(customer);
    }
}
