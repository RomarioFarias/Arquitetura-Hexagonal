package com.teste.haexagonal.adapters.inbound;

import com.teste.haexagonal.application.port.CustomerService;
import com.teste.haexagonal.template.CustomerTestTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("teste")
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;
    private final String URL_CUSTOMER = "/v1/customer/";

    @Test
    void findAllCustomer() throws Exception {
        when(customerService.listAllCustomer()).thenReturn(CustomerTestTemplate.getListCustomerTemplate());

        mockMvc.perform(get(URL_CUSTOMER + "listAllCustomer").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").isNotEmpty());
    }

}