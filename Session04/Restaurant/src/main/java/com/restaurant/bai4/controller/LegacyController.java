package com.restaurant.bai4.controller;

import com.restaurant.bai4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller("legacyControllerBai4")
@RequestMapping("/bai4")
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    @ResponseBody
    public String createOrder() {
        return "Tao don hang moi thanh cong";
    }

    @GetMapping("/menu")
    @ResponseBody
    public String getMenu(@RequestParam(value = "category", required = false, defaultValue = "chay") String category) {
        return "Menu: " + category;
    }

    @GetMapping("/products")
    public String getProducts(@RequestParam("category") String category, @RequestParam("limit") int limit, ModelMap model) {
        model.addAttribute("category", category).addAttribute("limit", limit).addAttribute("message", "Tim kiem thanh cong");
        return "productList";
    }
}
