package com.restaurant.bai2;

import com.restaurant.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/bai2/dishes")
    public String showDishes(Model model) {
        List<Dish> dishes = dishService.getAllDishes();

        model.addAttribute("dishes", dishes);

        return "dish-list";
    }
}