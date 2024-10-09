package com.pluralsight.paylist;

public class EmployeeList {
    private String employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public EmployeeList(String employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Getters and Setters
    public String getEmployeeId() {

        return employeeId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getHoursWorked() {

        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {

        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {

        return payRate;
    }

    public void setPayRate(double payRate) {

        this.payRate = payRate;
    }

    // Return gross pay
    public double getGrossPay() {

        return hoursWorked * payRate;
    }

    @Override
    public String toString() {
        return String.format("EmployeeID: %s\n" + "Name: %s\n" + "Hours Worked: %.0f hours\n" + "Pay Rate: $%.2f\n", employeeId, name, hoursWorked, payRate);
    }
}