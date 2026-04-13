package com.restaurant.bai5.model;

import java.util.List;

public class Combo {

    private static long counter = 0;

    private Long id;
    private String name;
    private List<String> itemList; //checkbox binding
    private String bannerPath;

    public Combo() {
        this.id = ++counter;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<String> getItemList() { return itemList; }
    public String getBannerPath() { return bannerPath; }

    public void setName(String name) { this.name = name; }
    public void setItemList(List<String> itemList) { this.itemList = itemList; }
    public void setBannerPath(String bannerPath) { this.bannerPath = bannerPath; }
}