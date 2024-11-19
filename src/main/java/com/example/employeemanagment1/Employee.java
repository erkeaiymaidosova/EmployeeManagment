package com.example.employeemanagment1;

public abstract class Employee {
    private String name;
    private String type;
    private double salary;
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", salary=" + salary +
                '}';
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public Employee(String name, String type, double salary) {
        this.name = name;
        this.type = type;
        this.salary = salary;
    }



    abstract double calculateSalary();
}
