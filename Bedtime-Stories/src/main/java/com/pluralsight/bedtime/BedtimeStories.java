package com.pluralsight.bedtime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeStories {

    public static void readStory(String filename) {

        try (FileInputStream fis = new FileInputStream(".//src//main//resources//DataFiles//" + filename);
             Scanner fileScanner = new Scanner(fis)) {

            while (fileScanner.hasNextLine()) {
                String input = fileScanner.nextLine();
                System.out.println(input);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while closing the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner scanley = new Scanner(System.in);

        System.out.println("I can't sleep, which story should I read?");
        System.out.println("\n(1) Goldilocks and the Three Bears");
        System.out.println("\n(2) Hansel and Gretel");
        System.out.println("\n(3) Mary Had A Little Lamb");
        System.out.print("\nSelection: ");

        int userSelection = scanley.nextInt();

        if (userSelection == 1) {
            System.out.println("Goldilocks and the Three Bears");
            readStory("goldilocks.txt");
        } else if (userSelection == 2) {
            System.out.println("Hansel and Gretel");
            readStory("hansel_and_gretel.txt");
        } else if (userSelection == 3) {
            System.out.println("Mary Had A Little Lamb");
            readStory("mary_had_a_little_lamb.txt");
        } else {
            System.out.println("Invalid selection.");
        }
        scanley.close();
    }
}

