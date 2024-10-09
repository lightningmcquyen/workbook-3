package com.pluralsight.quotes;

import java.util.Scanner;
import java.util.Random;

public class FamousQuotes {

    public static Scanner scanley = new Scanner(System.in);

    public static void main(String[] args) {

        String[] quotes = {
                "1. The only limit to our realization of tomorrow is our doubts of today. - Franklin D. Roosevelt",
                "2. In the middle of every difficulty lies opportunity. - Albert Einstein",
                "3. Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
                "4. The best way to predict the future is to create it. - Peter Drucker",
                "5. Do what you can, with what you have, where you are. - Theodore Roosevelt",
                "6. You miss 100% of the shots you don’t take. - Wayne Gretzky",
                "7. It does not matter how slowly you go as long as you do not stop. - Confucius",
                "8. Our lives begin to end the day we become silent about things that matter. - Martin Luther King Jr.",
                "9. The only way to do great work is to love what you do. - Steve Jobs",
                "10. Believe you can and you're halfway there. - Theodore Roosevelt",
        };


        Scanner scanley = new Scanner(System.in);
        Random random = new Random();
        boolean Continue = true;


        while (Continue) {
            System.out.println("Enter a number between 1 and 10 to see a quote (enter 0 for a random quote):");
            try {
                int choice = scanley.nextInt();

                if (choice == 0) {
                    int randomIndex = random.nextInt(quotes.length);
                    System.out.println(quotes[randomIndex]);
                } else if (choice >= 1 && choice <= 10) {
                    System.out.println(quotes[choice - 1]);
                } else {
                    System.out.println("Enter a valid number between 1 and 10.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number (1-10).");
                scanley.next();
            }

            // Lemme see another one
            System.out.println("\nDo you want to see another quote? (yes/no)");
            String userResponse = scanley.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                System.out.println("Have a great day!");
                break;
            }

        }
    }
}

