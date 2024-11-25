package com.example.employeemanagment1;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name, "Part Time", 0.0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }


    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate > 0) {
            this.hourlyRate = hourlyRate;
        } else {
            throw new IllegalArgumentException("Hourly rate must be positive.");
        }
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked >= 0) {
            this.hoursWorked = hoursWorked;
        } else {
            throw new IllegalArgumentException("Hours worked cannot be negative.");
        }
    }

    @Override
    double calculateSalary() {
        double calculatedSalary = hourlyRate * hoursWorked;
        setSalary(calculatedSalary);
        return calculatedSalary;
    }
}
