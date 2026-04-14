package com.validation.bai4.controller;

import com.validation.bai4.model.dto.RegisterDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") RegisterDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return "register-form";
        }
        return "redirect:/success";
    }
}