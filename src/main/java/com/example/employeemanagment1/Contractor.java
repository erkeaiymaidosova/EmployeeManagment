package com.example.employeemanagment1;

public class Contractor extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    private int maxHours;

    public Contractor(String name, double hourlyRate, int hoursWorked, int maxHours) {
        super(name, "Contractor", 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.maxHours = maxHours;
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

    public int getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(int maxHours) {
        if (maxHours > 0) {
            this.maxHours = maxHours;
        } else {
            throw new IllegalArgumentException("Max hours must be positive.");
        }
    }

    @Override
    double calculateSalary() {
        int effectiveHours = Math.min(hoursWorked, maxHours);
        double calculatedSalary = hourlyRate * effectiveHours;
        setSalary(calculatedSalary);
        return calculatedSalary;
    }
}
