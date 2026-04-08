package com.example.session04.repository;

import com.example.session04.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Nguyen Van A"));
        customers.add(new Customer(2, "Tran Thi B"));
        customers.add(new Customer(3, "Le Van C"));
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Customer findById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == (id))
                .findFirst()
                .orElse(null);
    }
}
