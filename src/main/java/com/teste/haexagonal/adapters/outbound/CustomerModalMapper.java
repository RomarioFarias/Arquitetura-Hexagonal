package com.teste.haexagonal.adapters.outbound;

import com.teste.haexagonal.adapters.inbound.CustomerDto;
import com.teste.haexagonal.application.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerModalMapper {
    private  ModelMapper modelMapper;


    public Customer toCustomer(CustomerDto customerDto){
       return modelMapper.map(customerDto, Customer.class);
    }

}
