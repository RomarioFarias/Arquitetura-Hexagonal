package com.teste.haexagonal.adapters.inbound;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("teste")
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    private final String url = "/v1/customer/";

    @Test
    public void findAllCustomer() throws Exception {
        mockMvc.perform(get(url + "listAllCustomer").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200));
                //.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").isNotEmpty());
    }

}