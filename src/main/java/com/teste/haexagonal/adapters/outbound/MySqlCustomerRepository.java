package com.teste.haexagonal.adapters.outbound;

import com.teste.haexagonal.application.entity.Customer;
import com.teste.haexagonal.application.port.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
@AllArgsConstructor
public class MySqlCustomerRepository implements CustomerRepository {

    private final SpringDataCustomerRepository springDataCustomerRepository;


    @Override
    public Customer save(Customer customer) {
        return springDataCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return springDataCustomerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long id) {
        springDataCustomerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return springDataCustomerRepository.save(customer);
    }
}
