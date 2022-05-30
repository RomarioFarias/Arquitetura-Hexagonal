package com.teste.haexagonal.adapters.config;

import com.teste.haexagonal.HaexagonalApplication;
import com.teste.haexagonal.adapters.outbound.CustomerModalMapper;
import com.teste.haexagonal.adapters.inbound.CustomerController;
import com.teste.haexagonal.adapters.inbound.CustomerMapper;
import com.teste.haexagonal.application.entity.Customer;
import com.teste.haexagonal.application.port.CustomerRepository;
import com.teste.haexagonal.application.service.CustomerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HaexagonalApplication.class)
public class ConfigBean {


    @Bean
    ModelMapper modelMapper (){
        return new ModelMapper();
    }

    @Bean
    CustomerServiceImpl customerServiceImpl(CustomerRepository customerRepository, CustomerModalMapper customerModalMapper) {
    ModelMapper toModal() {
        return new ModelMapper();
    }

        return new CustomerServiceImpl(customerRepository,customerModalMapper);
    @Bean
    CustomerServiceImpl customerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        Customer customer = new Customer();
        customer.setBirthDate("12/12/1994");
        customer.setName("Romario");
        Customer as = customerRepository.save(customer);
        return new CustomerServiceImpl(customerRepository,customerMapper);

    }




//    @Bean
//    CustomerMapper customerMapper(){
//        return new CustomerMapper(new ModelMapper());
//    }
}
