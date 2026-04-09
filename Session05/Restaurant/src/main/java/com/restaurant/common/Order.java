package com.restaurant.common;

import java.util.List;

public class Order {
    private List<Dish> items;
    private double total;
    private double tax;
    private double finalAmount;

    public Order(List<Dish> items, double total, double tax, double finalAmount) {
        this.items = items;
        this.total = total;
        this.tax = tax;
        this.finalAmount = finalAmount;
    }

    public List<Dish> getItems() { return items; }
    public double getTotal() { return total; }
    public double getTax() { return tax; }
    public double getFinalAmount() { return finalAmount; }
}