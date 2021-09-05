package com.teste.haexagonal.adapters.inbound;

import com.teste.haexagonal.application.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CustomerMapper {

    private final ModelMapper customerMapper;

    public Customer toCustomer(CustomerDto customerDto) {
        return this.customerMapper.map(customerDto, Customer.class);
    }

    public CustomerDto toCustomerDto(Customer customer) {
        return this.customerMapper.map(customer, CustomerDto.class);
    }

    public List<Customer> toListCustomer(List<CustomerDto> listCustomerDto) {
        return listCustomerDto.stream().map(customerDto -> toCustomer(customerDto)).collect(Collectors.toList());
    }

    public List<CustomerDto> toListCustomerDto(List<Customer> listCustomer) {
        return listCustomer.stream().map(customer -> toCustomerDto(customer)).collect(Collectors.toList());
    }
}
