package com.teste.haexagonal.application.port;

import com.teste.haexagonal.adapters.inbound.CustomerDto;
import com.teste.haexagonal.adapters.outbound.SpringDataCustomerRepository;
import com.teste.haexagonal.application.service.CustomerServiceImpl;
import com.teste.haexagonal.application.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("teste")
class CustomerServiceTest {


    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerServiceImpl customerService1;


    @MockBean
    SpringDataCustomerRepository customerRepository;

    @Test
    public void findAllCustomer() {

        when(this.customerRepository.findAll()).thenReturn(createListCustomer());

        assertTrue(this.customerService.listAllCustomer().size() > 0);
        verify(customerRepository, times(1)).findAll();

    }

    @Test
    public void insertCustomer() {
        //Adiciona a classe
        when(this.customerRepository.save(any(Customer.class))).thenReturn((this.createCustomer()));
        var customer = this.customerService.insertCustomer(this.createCustomerDto());
        assertTrue(customer != null);
        verify(customerRepository, times(1)).save(any());
    }


    private List<Customer> createListCustomer() {

        return List.of(createCustomer());
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setBirthDate("12/12/1994");
        customer.setName("Teste");
        return customer;
    }

    private CustomerDto createCustomerDto() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1l);
        customerDto.setBirthDate("12/12/1994");
        customerDto.setName("Teste");
        return customerDto;
    }


}