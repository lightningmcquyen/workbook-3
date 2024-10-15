package com.pluralsight.onlinestore;

public class Cart {
    private Product[] items;
    private int itemCount;

    // Constructor
    public Cart() {
        items = new Product[10];
        itemCount = 0;
    }

    // Add a product to the cart
    public void addProducts(Product product) {
        if (itemCount >= items.length) {
            Product[] newArray = new Product[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                newArray[i] = items[i];
            }
            items = newArray;
        }
        items[itemCount] = product;
        itemCount++;
    }

    // Remove a product by SKU
    public void remove(String sku) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getSku().equals(sku)) {
                for (int j = i; j < itemCount - 1; j++) {
                    items[j] = items[j + 1];
                }
                // Clear the last item and decrement itemCount
                items[itemCount - 1] = null;
                itemCount--;
                System.out.println("Product removed from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    // Clear all items in the cart
    public void clear() {
        items = new Product[10];
        itemCount = 0;
    }

    // Calculate the total price of the cart
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    // Get all products in the cart
    public Product[] getProducts() {
        Product[] productArray = new Product[itemCount];
        for (int i = 0; i < itemCount; i++) {
            productArray[i] = items[i];
        }
        return productArray;
    }


    @Override
    public String toString() {
        String result = "Your Cart:\n";
        if (itemCount == 0) {
            result += "Cart is empty.";
        } else {
            for (int i = 0; i < itemCount; i++) {
                result += items[i].toString() + "\n";
            }
            result += "Total: $" + getTotal();
        }
        return result;
    }
}