package com.restaurant.common;

public class Dish {
    private Long id;
    private String name;
    private double price;
    private boolean isAvailable;

    public Dish() {}

    public Dish(Long id, String name, double price, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setAvailable(boolean available) { isAvailable = available; }
}