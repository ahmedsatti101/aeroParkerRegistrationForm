package com.aeroParker.registrationForm.Service;

import com.aeroParker.registrationForm.Entity.Customers;
import com.aeroParker.registrationForm.Repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomersRepository customersRepository;

    public Customers addNewCustomer(Customers newCustomer) {
        return customersRepository.save(newCustomer);
    }
}
