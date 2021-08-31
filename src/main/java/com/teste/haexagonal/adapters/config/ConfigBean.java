package com.teste.haexagonal.adapters.config;

import com.teste.haexagonal.HaexagonalApplication;
import com.teste.haexagonal.application.port.CustomerRepository;
import com.teste.haexagonal.application.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HaexagonalApplication.class)
public class ConfigBean {

    @Bean
    CustomerServiceImpl customerServiceImpl(CustomerRepository customerRepository) {

        return new CustomerServiceImpl(customerRepository);

    }
}
