package com.pluralsight.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchEngineLogger {

        private static String LOG_FILE = "logs.txt";

        public static void main(String[] args) {

            logAction("A. Launching the application");

            Scanner scanley = new Scanner(System.in);
            System.out.print("Enter a search term: ");
            String searchTerm = scanley.nextLine();

            logAction("B. Searching for a term: " + searchTerm);
            System.out.println("Searching..... " + searchTerm);

            logAction("C. Exiting the application");
            scanley.close();
        }

        private static void logAction (String action) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                writer.write(action);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error!  " + e.getMessage());
            }
        }
    }

