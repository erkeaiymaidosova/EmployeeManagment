package com.example.employeemanagment1;

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double salary) {
        super(name, "Full-time", salary);
    }

    @Override
    double calculateSalary() {
        return getSalary();
    }
}
