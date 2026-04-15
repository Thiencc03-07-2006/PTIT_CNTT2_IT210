package com.validation.bai5.controller;

import com.validation.bai5.model.dto.TourDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tour")
public class TourController {

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("tour", new TourDto());
        return "create-tour";
    }

    @PostMapping("/create")
    public String createTour(@Valid @ModelAttribute("tour") TourDto tour, BindingResult result) {
        if (result.hasErrors()) {
            return "create-tour";
        }
        return "redirect:/tour/success";
    }
}