package com.example.session02.bai5;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {

        // Đưa message sang JSP
        model.addAttribute("errorMessage", ex.getMessage());

        return "error"; // → /WEB-INF/views/error.jsp
    }
}