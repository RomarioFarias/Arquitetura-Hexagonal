package com.teste.haexagonal.application.service;

import com.teste.haexagonal.adapters.inbound.CustomerDto;
import com.teste.haexagonal.application.entity.Customer;
import com.teste.haexagonal.application.port.CustomerRepository;
import com.teste.haexagonal.application.port.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;


    @Override
    public Customer insertCustomer(CustomerDto customerDto) {

        return customerRepository.save(this.convertCostumer(customerDto));
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
    public Customer updateCustomer(CustomerDto customerDto) {
        return this.customerRepository.updateCustomer(this.convertCostumer(customerDto));
    }
}
