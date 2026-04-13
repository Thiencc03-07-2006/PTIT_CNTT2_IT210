package com.restaurant.bai2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/merchant/dish")
public class DishController {

    // Chỉ viết DUY NHẤT 1 lần
    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList(
                "Món chính",
                "Đồ uống",
                "Tráng miệng",
                "Topping"
        );
    }

    // API 1: Form thêm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    // API 2: Form sửa
    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish-edit";
    }

    // API 3: Trang tìm kiếm
    @GetMapping("/search")
    public String showSearchPage() {
        return "dish-search";
    }
}