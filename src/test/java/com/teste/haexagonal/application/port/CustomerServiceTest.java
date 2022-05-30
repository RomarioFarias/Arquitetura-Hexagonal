package com.teste.haexagonal.application.port;

import com.teste.haexagonal.application.service.CustomerServiceImpl;
import com.teste.haexagonal.template.CustomerTestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
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

    @InjectMocks
    CustomerServiceImpl customerService1;
    @Mock
    CustomerRepository customerRepository;


    @Mock
    CustomerRepository customerRepository;

    @MockBean
    ModelMapper modelMapper;

    @BeforeEach
    public void initiMOcl(){
        MockitoAnnotations.openMocks(this);
    }
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllCustomer() {

        when(this.customerRepository.findAll()).thenReturn(CustomerTestTemplate.getListCustomerTemplate());

        assertTrue(this.customerService1.listAllCustomer().size() > 0);
        verify(customerRepository, times(1)).findAll();

    }

    @Test
    public void insertCustomer() {
        when(this.customerRepository.save(any())).thenReturn(CustomerTestTemplate.getCustomerTemplate());
        var customer = this.customerService1.insertCustomer(CustomerTestTemplate.getCustomerTemplate());
        assertTrue(customer != null);
    }
}