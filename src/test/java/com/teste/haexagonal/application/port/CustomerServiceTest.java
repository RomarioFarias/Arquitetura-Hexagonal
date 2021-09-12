package com.teste.haexagonal.application.port;

import com.teste.haexagonal.application.service.CustomerServiceImpl;
import com.teste.haexagonal.template.CustomerTestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("teste")
class CustomerServiceTest {


    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    CustomerRepository customerRepository;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllCustomer() {

        when(this.customerRepository.findAll()).thenReturn(CustomerTestTemplate.getListCustomerTemplate());

        assertTrue(this.customerService.listAllCustomer().size() > 0);
        verify(customerRepository, times(1)).findAll();

    }

    @Test
    public void insertCustomer() {
        when(this.customerRepository.save(any())).thenReturn(CustomerTestTemplate.getCustomerTemplate());
        var customer = this.customerService.insertCustomer(CustomerTestTemplate.getCustomerTemplate());
        assertTrue(customer != null);
    }
}