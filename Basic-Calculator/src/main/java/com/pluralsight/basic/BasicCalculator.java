package com.pluralsight.basic;

import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanley = new Scanner(System.in);
        boolean continueCalc = true;

        while (continueCalc) {
            String selection = displayMenu(scanley);

            if (selection.equalsIgnoreCase("E")) {
                continueCalc = false;
                System.out.println("Goodbye!");
            } else if (selection.equalsIgnoreCase("A")) {
                performAddition(scanley);
            } else if (selection.equalsIgnoreCase("S")) {
                performSubtraction(scanley);
            } else if (selection.equalsIgnoreCase("M")) {
                performMultiplication(scanley);
            } else if (selection.equalsIgnoreCase("D")) {
                performDivision(scanley);
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static String displayMenu(Scanner scanley) {
        System.out.println("\n---Possible Calculations---");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultiply");
        System.out.println("(D)ivide");
        System.out.println("(E)xit");
        System.out.print("Enter your selection (A,S,M,D,E): ");
        return scanley.nextLine();
    }

    private static void performAddition(Scanner scanley) {
        System.out.print("Enter the first number: ");
        float input1 = scanley.nextFloat();
        System.out.print("Enter the second number: ");
        float input2 = scanley.nextFloat();
        float add = input1 + input2;
        System.out.printf("Result: %.2f\n", add);
    }

    private static void performSubtraction(Scanner scanley) {
        System.out.print("Enter the first number: ");
        float input1 = scanley.nextFloat();
        System.out.print("Enter the second number: ");
        float input2 = scanley.nextFloat();
        float subtract = input1 - input2;
        System.out.printf("Result: %.2f\n", subtract);
    }

    private static void performMultiplication(Scanner scanley) {
        System.out.print("Enter the first number: ");
        float input1 = scanley.nextFloat();
        System.out.print("Enter the second number: ");
        float input2 = scanley.nextFloat();
        float multiply = input1 * input2;
        System.out.printf("Result: %.2f\n", multiply);
    }

    private static void performDivision(Scanner scanley) {
        System.out.print("Enter the first number: ");
        float input1 = scanley.nextFloat();
        System.out.print("Enter the second number: ");
        float input2 = scanley.nextFloat();
        float divide = input1 / input2;
        System.out.printf("Result: %.2f\n", divide);
        }
    }
