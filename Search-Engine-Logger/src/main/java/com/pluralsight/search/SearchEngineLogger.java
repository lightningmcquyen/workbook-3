package com.pluralsight.search;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchEngineLogger {

        private static String LOG_FILE = "C:\\pluralsight\\workbook-3\\Search-Engine-Logger\\logs.txt";

        public static void main(String[] args) {

            logAction("launch");

            Scanner scanley = new Scanner(System.in);
            String searchTerm;

            while (true) {
                System.out.print("Enter a search term (Press 'x' to exit): ");
                searchTerm = scanley.nextLine();

                if (searchTerm.equalsIgnoreCase("x")) {
                    logAction("Exit");
                    break;
                }

                logAction("Search : " + searchTerm);
                System.out.println("Searching..... " + searchTerm);
            }
            scanley.close();
        }

        private static void logAction (String action) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = now.format(formatter);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                writer.write(action);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error!  " + e.getMessage());
            }
        }
    }

