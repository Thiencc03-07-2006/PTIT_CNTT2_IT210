package com.example.session02.model;

public class Product {
    int id;
    String name;
    double price;
    boolean status;

    public Product(int id, String name, double price, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isStatus() { return status; }
}
