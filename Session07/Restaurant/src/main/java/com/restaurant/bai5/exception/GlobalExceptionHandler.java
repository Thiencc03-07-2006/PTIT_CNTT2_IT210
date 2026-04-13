package com.restaurant.bai5.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public String handleFileSizeException(IllegalStateException ex, Model model) {
        if (ex.getMessage() != null && ex.getMessage().contains("exceeds maximum size")) {
            model.addAttribute("error", "File quá lớn! Tối đa 10MB.");
            return "error-file";
        }
        return "error";
    }
}