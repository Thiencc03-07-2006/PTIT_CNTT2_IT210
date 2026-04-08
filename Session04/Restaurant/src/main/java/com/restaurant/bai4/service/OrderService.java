package com.restaurant.bai4.service;

import com.restaurant.bai4.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderService4")
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }
}
