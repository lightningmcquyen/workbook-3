package com.pluralsight.inventory;

public class Products {
    private String productId;
    private String name;
    private double price;
    private int quantity;

    public Products(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, $%.2f, %d", productId, name, price, quantity);
    }
}
