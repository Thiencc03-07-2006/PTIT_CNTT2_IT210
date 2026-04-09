package com.restaurant.bai3;

import com.restaurant.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminDishController {

    @Autowired
    private AdminDishService service;

    @GetMapping("/bai3/edit/{id}")
    public String editDish(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {

        Dish dish = service.findById(id);

        // Bẫy dữ liệu: không tồn tại
        if (dish == null) {
            redirectAttributes.addFlashAttribute(
                    "error", "Không tìm thấy món ăn yêu cầu!"
            );
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}