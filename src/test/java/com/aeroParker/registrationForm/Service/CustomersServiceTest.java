package com.aeroParker.registrationForm.Service;

import com.aeroParker.registrationForm.Controller.CustomerController;
import com.aeroParker.registrationForm.Entity.Customers;
import com.aeroParker.registrationForm.Repository.CustomersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@WebMvcTest(CustomerController.class)
public class CustomersServiceTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    private String api = "http://localhost";

    @BeforeEach
    public void setApi() {
        api = api.concat(":").concat(port + "").concat("/registration");


//        when(customersRepository.save(any(Customers.class))).thenReturn(customer);
    }

    @Test
    @DisplayName("Verify customer service class has been called at least once")
    public void test1() throws Exception {
        Customers customer = new Customers();
        customer.setId(1);
        customer.setRegistered(LocalDateTime.now());
        customer.setEmail("ahmedM@gmail.com");
        customer.setTitle("Mr");
        customer.setFirstName("Ahmed");
        customer.setLastName("Mohamed");
        customer.setAddressLineOne("Parkloo avenue 1");
        customer.setCity("Dublin");
        customer.setPostcode("D45 0YU");
        customer.setPhoneNumber("0743789473");

        String customerJson = objectMapper.writeValueAsString(customer);

        mockMvc.perform(post(api)
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson))
                .andExpect(status().isCreated());
    }
}
