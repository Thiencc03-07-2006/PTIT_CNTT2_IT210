package com.restaurant.bai4;

import com.restaurant.bai3.AdminDishService;
import com.restaurant.common.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("dishDetailController4")
@RequestMapping("/bai4")
public class DishDetailController {

    private final AdminDishService adminDishService;

    public DishDetailController(AdminDishService adminDishService) {
        this.adminDishService = adminDishService;
    }

    @GetMapping("/dishes/{id}")
    public String showDishDetail(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Dish dish = adminDishService.findById(id);

        if (dish == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        } else {
            model.addAttribute("dish", dish);
        }

        return "dish-detail";
    }
}