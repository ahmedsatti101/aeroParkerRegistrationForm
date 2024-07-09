package com.aeroParker.registrationForm.Repository;

import com.aeroParker.registrationForm.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}
