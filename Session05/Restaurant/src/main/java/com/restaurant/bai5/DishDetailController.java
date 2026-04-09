package com.restaurant.bai5;

import com.restaurant.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("dishDetailController5")
public class DishDetailController {

    @Autowired
    private OrderRepository repo;

    @GetMapping("/bai5/dish/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {

        Dish dish = repo.findAllAvailable()
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn!");
            return "error-page";
        }

        model.addAttribute("dish", dish);
        return "dish-detail";
    }
}