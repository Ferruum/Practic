package com.example.demo.models;

public class Inventory {
    private int id;
    private String name;
    private String type;
    private String bladelength;
    private String price;

    public Inventory(int id, String name, String type, String bladelength, String price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.bladelength = bladelength;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBladelength() {
        return bladelength;
    }

    public void setBladelength(String bladelength) {
        this.bladelength = bladelength;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
