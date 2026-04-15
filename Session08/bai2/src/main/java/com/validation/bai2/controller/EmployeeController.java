package com.validation.bai2.controller;

import com.validation.bai2.model.dto.EmployeeDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @GetMapping("/hr/add-employee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "employee-form";
    }
    @PostMapping("/hr/add-employee")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-form";
        }
        return "redirect:/hr/success";
    }
}