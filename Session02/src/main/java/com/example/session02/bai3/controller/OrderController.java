package com.example.session02.bai3.controller;

import com.example.session02.bai3.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session, HttpServletRequest request, Model model) {
        ServletContext application = request.getServletContext();
        //Check login
//        if (session.getAttribute("loggedUser") == null) {
//            return "redirect:/login";
//        }

        //Fake data
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("OD01", "Laptop", 15000000, new Date()));
        orders.add(new Order("OD02", "Chuột", 300000, new Date()));
        orders.add(new Order("OD03", "Bàn phím", 800000, new Date()));

        model.addAttribute("orderList", orders);

        //FIX Race Condition bằng synchronized
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            count++;
            application.setAttribute("totalViewCount", count);
        }

        return "orders";
    }
}