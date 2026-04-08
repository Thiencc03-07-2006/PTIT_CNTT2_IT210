package com.restaurant.bai3.controller;

import com.restaurant.bai3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("legacyControllerBai3")
@RequestMapping("/bai3")
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
}
