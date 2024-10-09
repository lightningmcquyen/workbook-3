package com.pluralsight.bedtime;

import java.io.*;
import java.util.Scanner;

public class BedtimeStories {

    public static void readStory(String filename) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("./src/main/resources/DataFiles/");
        Scanner fileScanner = new Scanner(fis);

        while (fileScanner.hasNextLine()) {
            String input = fileScanner.nextLine();
            System.out.println(input);
        }
    }

    public static void main(String[] args) {

        Scanner scanley = new Scanner(System.in);

        System.out.println("I can't sleep, which story should I read?");
        System.out.println("\n(1) Goldilocks and the Three Bears");
        System.out.println("\n(2) Hansel and Gretel");
        System.out.println("\n(3) Mary Had A Little Lamb");
        System.out.println("\nSelection: ");

        int userSelection = scanley.nextInt();

        if (userSelection == 1) {
            System.out.println("Goldilocks and the Three Bears");
            readStory ("goldilocks.txt");
        }
        else if (userSelection == 2) {
            System.out.println("Hansel and Gretel");
            readStory ("hansel_and_gretel.txt");
        } else (userSelection == 3) {
            System.out.println("Mary Had A Little Lamb");
            readStory ("mary_had_a_little_lamb.txt");
        }
    }
}