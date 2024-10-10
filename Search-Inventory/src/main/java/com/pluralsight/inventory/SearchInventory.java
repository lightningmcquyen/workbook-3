package com.pluralsight.inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchInventory {

    private static ArrayList<Products> getInitialInventory() {
        ArrayList<Products> initialInventory = new ArrayList<>();

        initialInventory.add(new Products("Product1", "Squish-mallow", 29.99, 1));
        initialInventory.add(new Products("Product2", "Cat Litter", 40.99, 4));
        initialInventory.add(new Products("Product3", "Lottery Ticket", 2.00, 7));
        initialInventory.add(new Products("Product4", "Lip Gloss", 12.99, 9));
        initialInventory.add(new Products("Product5", "Books", 24.99, 7));

        return initialInventory;
    }

        public static void main(String[] args) {

        ArrayList<Products> inventory = getInitialInventory();

        System.out.println("Current Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("0");
        } else {
            for (Products item : inventory) {
                System.out.printf("ID: %s, Name: %s, Price: $%.2f, Quantity: %d%n",
                        item.getProductId(), item.getName(), item.getPrice(), item.getQuantity());
            }
        }
    }


    // Read inventory from inventory.csv
    private static ArrayList<Products> getInventory() {
        ArrayList<Products> inventory = new ArrayList<>();

        try (BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/DataFiles/inventory.csv"))) {
            String header = buffReader.readLine(); // Reads the header line
            if (header != null) {
                System.out.println(header);
            }

            String line;
            while ((line = buffReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                if (tokens.length == 4) {
                    String productId = tokens[0].trim();
                    String name = tokens[1].trim();
                    double price = Double.parseDouble(tokens[2].trim());
                    int quantity = Integer.parseInt(tokens[3].trim());

                    // Inventory
                    inventory.add(new Products(productId, name, price, quantity));
                }
                else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Format Error: " + e);
        }
        return inventory;
    }
}