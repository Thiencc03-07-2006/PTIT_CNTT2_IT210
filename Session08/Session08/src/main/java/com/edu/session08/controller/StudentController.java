package com.edu.session08.controller;

import com.edu.session08.model.dto.StudentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "student-form";
    }

    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("student") StudentDTO student,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "student-form";
        }

        // giả lập lưu DB
        model.addAttribute("message", "Tạo student thành công!");
        return "success";
    }
}