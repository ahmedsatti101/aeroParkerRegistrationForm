package com.aeroParker.registrationForm.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CustomersServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class CustomersServiceImplTestContextConfiguration {
        @Bean
        public CustomerService customerService() {
            return new CustomerService();
        }
    }

    @LocalServerPort
    private int port;

    private String api = "http://localhost";

    @BeforeEach
    public void setApi() {
        api = api.concat(":").concat(port + "").concat("/registration");
    }
}
