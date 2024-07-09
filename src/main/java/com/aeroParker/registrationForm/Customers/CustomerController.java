package com.aeroParker.registrationForm.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class CustomerController {
    @Autowired
    private CustomersRepository customersRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customers newCustomer(@RequestBody Customers customer) {
        return customersRepository.save(customer);
    }
}
