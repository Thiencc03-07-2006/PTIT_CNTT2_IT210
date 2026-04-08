package com.example.session04.controller;

import com.example.session04.model.Customer;
import com.example.session04.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService service = new CustomerService();

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", service.getAllCustomer());
        return "customer-list";
    }

    @GetMapping("/{id}")
    public String customerDetail(@PathVariable("id") int id, Model model) {
        Customer c = service.getById(id);
        model.addAttribute("customer", c);
        return "customer-detail";
    }
}
