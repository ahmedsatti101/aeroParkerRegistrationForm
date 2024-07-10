package com.aeroParker.registrationForm.Service;

import com.aeroParker.registrationForm.Entity.Customers;
import com.aeroParker.registrationForm.Repository.CustomersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class CustomersServiceTest {
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomersRepository customersRepository;

    @LocalServerPort
    private int port;

    private String api = "http://localhost";

    @BeforeEach
    public void setApi() {
        api = api.concat(":").concat("5000").concat("/registration");
    }

    @Test
    @DisplayName("Verify customer service class has been called at least once")
    public void verifyServiceHasBeenCalledOnce() {
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

       when(customersRepository.save(any(Customers.class))).thenReturn(customer);

       customerService.addNewCustomer(customer);

       verify(customersRepository).save(customer);
    }
}
