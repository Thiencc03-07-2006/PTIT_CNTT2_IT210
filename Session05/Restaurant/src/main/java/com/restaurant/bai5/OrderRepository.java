package com.restaurant.bai5;

import com.restaurant.common.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    public List<Dish> findAllAvailable() {
        return List.of(
                new Dish(1L, "Phở bò", 50000, true),
                new Dish(2L, "Bún chả", 45000, true),
                new Dish(3L, "Cơm tấm", 40000, true)
        );
    }
}
