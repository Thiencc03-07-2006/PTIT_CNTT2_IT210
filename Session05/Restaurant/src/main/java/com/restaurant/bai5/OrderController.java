package com.restaurant.bai5;

import com.restaurant.common.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/bai5/order")
    public String orderPage(Model model) {

        Order order = service.createOrder();

        model.addAttribute("order", order);

        return "order";
    }
}