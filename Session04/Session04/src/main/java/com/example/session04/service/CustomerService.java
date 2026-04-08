package com.example.session04.service;

import com.example.session04.model.Customer;
import com.example.session04.repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    CustomerRepository repository = new CustomerRepository();

    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    public Customer getById(int id) {
        return repository.findById(id);
    }
}
