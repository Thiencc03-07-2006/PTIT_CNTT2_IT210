package com.restaurant.bai5.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public String findById(Long id) {
        return "Thong tin don hang: " + id;
    }

    public String save() {
        return "Tao don hang thanh cong";
    }

    public String deleteById(Long id) {
        return "Da huy don hang: " + id;
    }
}
