package com.aeroParker.registrationForm.Repository;

import com.aeroParker.registrationForm.Entity.Customers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CustomersRepositoryTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomersRepository customersRepository;

    @LocalServerPort
    private int port;

    private String api = "http://localhost";

    @BeforeEach
    public void setApi() {
        api = api.concat(":").concat(port + "").concat("/registration");
    }

    @Test
    @DisplayName("Verify customer repository has been called at least once")
    public void verifyRepositoryHasBeenCalledOnce () throws Exception {
        Customers customer = new Customers();
        customer.setId(1);
        customer.setRegistered(LocalDateTime.now());
        customer.setEmail("ahmedysatti@gmail.com");
        customer.setTitle("Mr");
        customer.setFirstName("Ahmed");
        customer.setLastName("Mohamed");
        customer.setAddressLineOne("Parkloo avenue 1");
        customer.setCity("Dublin");
        customer.setPostcode("D45 0YU");
        customer.setPhoneNumber("0743789473");

        String customerJson = objectMapper.writeValueAsString(customer);

        when(customersRepository.save(any(Customers.class))).thenReturn(customer);

        mockMvc.perform(post(api)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(customerJson))
                .andExpect(status().isCreated());

        verify(customersRepository, times(1)).save(any(Customers.class));
    }
}
