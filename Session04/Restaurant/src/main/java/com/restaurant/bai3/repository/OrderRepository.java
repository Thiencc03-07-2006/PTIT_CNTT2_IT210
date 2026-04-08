package com.restaurant.bai3.repository;

import org.springframework.stereotype.Repository;

@Repository("orderRepositoryBai3")
public class OrderRepository {

    public String getAllOrders() {
        return "Danh sach toan bo don hang";
    }

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }
}
