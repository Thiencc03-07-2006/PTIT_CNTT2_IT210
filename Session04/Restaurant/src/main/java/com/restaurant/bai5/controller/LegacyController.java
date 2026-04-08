package com.restaurant.bai5.controller;

import com.restaurant.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LegacyController {

    private final OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public String getOrder(@PathVariable("id") String id) {
        try {
            Long orderId = Long.parseLong(id);
            return orderService.getOrderById(orderId);
        } catch (NumberFormatException e) {
            return "ID don hang phai la mot so";
        }
    }

    @PostMapping("/orders")
    @ResponseBody
    public String createOrder() {
        return orderService.createOrder();
    }

    @DeleteMapping("/orders/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable("id") Long id) {
        return orderService.deleteOrder(id);
    }
}
