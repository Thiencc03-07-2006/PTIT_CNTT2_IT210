package com.restaurant.bai5;

import com.restaurant.common.Dish;
import com.restaurant.common.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public Order createOrder() {
        List<Dish> items = repo.findAllAvailable();

        double total = items.stream()
                .mapToDouble(Dish::getPrice)
                .sum();

        double tax = total * 0.1; // 10%
        double finalAmount = total + tax;

        return new Order(items, total, tax, finalAmount);
    }
}