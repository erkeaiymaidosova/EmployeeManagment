package com.example.employeemanagment1;

public class FullTimeEmployee extends Employee{
    public FullTimeEmployee(String name, String type, double salary) {
        super(name, type, salary);
    }

    @Override
    double calculateSalary() {
        return 0;
    }
}
