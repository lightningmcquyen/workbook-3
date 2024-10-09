package com.pluralsight.paylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PayrollList {
    public static void main(String[] args) {
        ArrayList<EmployeeList> employeeList = new ArrayList<>();

        try (BufferedReader buffReader = new BufferedReader(new FileReader("./src/main/resources/DataFiles/employees.csv"))) {
            buffReader.readLine(); // Skip the header
            String line;

            while ((line = buffReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                String employeeId = tokens[0];
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                // Creating EmployeeList object
                EmployeeList employee = new EmployeeList(employeeId, name, hoursWorked, payRate);
                employeeList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adding employee
        EmployeeList q = new EmployeeList("1 ", " Quyen Vong", 40, 1.25);
        employeeList.add(q);

        // Printing employee details
        for (EmployeeList employee : employeeList) {
            System.out.println(employee);
        }
    }
}
