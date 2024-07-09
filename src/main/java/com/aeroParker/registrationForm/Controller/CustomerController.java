package com.aeroParker.registrationForm.Controller;

import com.aeroParker.registrationForm.Entity.Customers;
import com.aeroParker.registrationForm.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customers newCustomer(@RequestBody Customers customer) {
        return customerService.addNewCustomer(customer);
    }
}
