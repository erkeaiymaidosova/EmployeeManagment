package com.example.employeemanagment1;

public class Contractor extends Employee{
    private int workedHour;

    @Override
    public String toString() {
        return "Contractor{" +
                "workedHour=" + workedHour +
                ", hourlyRate=" + hourlyRate +
                '}';
    }

    private int hourlyRate;

    public Contractor(String name, String type, double salary, int workedHour, int hourlyRate) {
        super(name, type, salary);
        this.workedHour = workedHour;
        this.hourlyRate = hourlyRate;
    }

    public int getWorkedHour() {
        return workedHour;
    }

    public void setWorkedHour(int workedHour) {
        this.workedHour = workedHour;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }


    public Contractor(String name, String type, double salary) {
        super(name, type, salary);
    }

    @Override
    double calculateSalary() {
        return 0;
    }
}
