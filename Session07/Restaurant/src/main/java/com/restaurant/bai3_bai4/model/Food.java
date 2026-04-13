package com.restaurant.bai3_bai4.model;

public class Food {
    private static long counter = 0;

    private Long id;
    private String name;
    private String category;
    private double price;
    private String imagePath; // lưu đường dẫn ảnh

    public Food() {
        this.id = ++counter;
    }

    public Food(String name, String category, double price, String imagePath) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public static long getCounter() {
        return counter;
    }
}
