package com.pluralsight.onlinestore;

public class Product {
    private String sku;
    private String name;
    private double price;
    private String department;

    public Product(String sku, String name, double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return String.format("SKU: %s\nProduct Name: %s\nPrice: $%.2f\nDepartment: %s\n", sku, name, price, department);
    }
}