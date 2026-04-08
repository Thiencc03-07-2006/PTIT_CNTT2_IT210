package com.restaurant.bai1.repository;

import org.springframework.stereotype.Repository;

@Repository("orderRepositoryBai1")
public class OrderRepository {

    public String getAllOrders() {
        return "Danh sach toan bo don hang";
    }

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }
}
