package com.pluralsight.onlinestore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class OnlineStore {

    private ArrayList<Product> inventory = new ArrayList<>();
    private Cart cart = new Cart();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        store.loadProducts("src/main/resources/DataFiles/products.csv");
        store.start();
    }

    public void loadProducts(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                if (tokens.length < 4) {
                    System.out.println("Invalid product line: " + line);
                    continue;
                }
                String sku = tokens[0];
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                String department = tokens[3];

                inventory.add(new Product(sku, name, price, department));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing price: " + e.getMessage());
        }
    }

    public void start() {

        final String RESET = "\033[0m";  // Reset to default color
        final String GREEN = "\033[32m";  // Green
        final String PINK = "\033[35m";    // Pink

        while (true) {
            System.out.println(PINK + "Quyen's Quick Mart" + RESET);
            System.out.println(PINK + "(1) Display Products" + RESET);
            System.out.println(GREEN + "(2) Search Products" + RESET);
            System.out.println(PINK + "(3) Display Cart" + RESET);
            System.out.println(GREEN + "(4) Remove Item from Cart" + RESET);
            System.out.println(PINK + "(5) Clear Cart" + RESET);
            System.out.println(GREEN + "(6) Exit" + RESET);
            System.out.print(PINK + "Enter Your Option (1-6): " + RESET);


            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    searchProducts();
                    break;
                case 3:
                    displayCart();
                    break;
                case 4:
                    removeFromCart();
                    break;
                case 5:
                    cart.clear();
                    System.out.println("Cart cleared.");
                    break;
                case 6:
                    System.out.println("Exiting Mart...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayProducts() {
        System.out.println("Product List:");
        for (Product product : inventory) {
            System.out.println(product);
        }
        System.out.println("Enter a product SKU to add to cart, or type 'back' to go back:");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("back")) {
            return;
        }

        Product productAdd = null;
        for (Product product : inventory) {
            if (product.getSku().equalsIgnoreCase(input)) {
                productAdd = product;
                break;
            }
        }

        if (productAdd != null) {
            cart.addProducts(productAdd);
            System.out.println(productAdd.getName() + " added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void searchProducts() {
        System.out.print("Enter item name or department: ");
        String searchTerm = scanner.nextLine().toLowerCase();
        ArrayList<Product> foundProducts = new ArrayList<>();

        for (Product product : inventory) {
            if (product.getName().toLowerCase().contains(searchTerm) ||
                    product.getDepartment().toLowerCase().contains(searchTerm)) {
                foundProducts.add(product);
            }
        }

        if (foundProducts.isEmpty()) {
            System.out.println("No products found matching your search.");
        } else {
            System.out.println("Search Results: ");
            for (Product product : foundProducts) {
                System.out.println(product);
            }
        }
    }

    public void displayCart() {
        System.out.println("Your Cart:");
        if (cart.getProducts().length == 0) {
            System.out.println("Cart is empty.");
        } else {
            for (Product product : cart.getProducts()) {
                System.out.println(product);
            }
            System.out.printf("Total: $%.2f%n", cart.getTotal());
            System.out.println("Please see virtual cashier for check-out. Have a wonderful rest of your day!");
        }
    }

    public void removeFromCart() {
        System.out.print("Enter SKU of the product to remove: ");
        String skuToRemove = scanner.nextLine();
        cart.remove(skuToRemove);
    }
}