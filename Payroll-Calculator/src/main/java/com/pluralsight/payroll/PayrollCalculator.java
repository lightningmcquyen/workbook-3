package com.pluralsight.payroll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {

        try (BufferedReader buffReader = new BufferedReader(new FileReader("./src/main/resources/DataFiles/employees.csv"))) {
            String header = buffReader.readLine(); // Skip the header

            String line;
            while ((line = buffReader.readLine()) != null) {
                String[] tokens = line.split("\\|");

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                // Formatting
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                System.out.printf("ID: %d, Name: %s, Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

