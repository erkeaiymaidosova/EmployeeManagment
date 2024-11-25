package com.example.employeemanagment1;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private Button calculate;

    @FXML
    private Button delete;
    @FXML
    private Button add;
    @FXML
    private Label label;
    @FXML
    private Label max;

    @FXML
    private TextField maxHours;
    @FXML
    private TextField hour;
    @FXML
    private ListView list;

    @FXML
    private Label hourL;

    @FXML
    private TextField name;

    @FXML
    private TextField rate;

    @FXML
    private Label rateL;
    @FXML
    private Label hoursWorked;

    @FXML
    private ComboBox<String> select;
    ObservableList<Employee> employers = FXCollections.observableArrayList();

    public void initialize() {
        select.getItems().addAll("Contract", "Part time", "Full time");
        list.setItems(employers);

        employers.addListener((ListChangeListener<Employee>) change -> {
            while (change.next()) {
                updateDeviceFieldsVisibility();
            }
        });
    }
    @FXML
    private void calculateSalary(ActionEvent event) {
        if (employers.isEmpty()) {
            label.setText("No employees to calculate salaries for.");
            return;
        }

        StringBuilder salaryDetails = new StringBuilder("Calculated Salaries:\n");

        for (Employee employee : employers) {
            double salary = employee.calculateSalary();
            employee.setSalary(salary);
            salaryDetails.append(employee.getName())
                    .append(" (")
                    .append(employee.getType())
                    .append("): ")
                    .append(String.format("%.2f", salary))
                    .append("\n");
        }

        label.setText(salaryDetails.toString());
        list.refresh();
    }


    @FXML
    private void updateDeviceFieldsVisibility() {
        String selectedType = select.getValue();
        System.out.println("Selected type: " + selectedType);


        hourL.setVisible(false);
        rateL.setVisible(false);
        hour.setVisible(false);
        rate.setVisible(false);
        max.setVisible(false);
        maxHours.setVisible(false);
        if ("Contract".equals(selectedType)) {
            hourL.setText("Hours worked:");
            rateL.setText("Hourly rate:");
            max.setText("Max hours:");
            hourL.setVisible(true);
            hour.setVisible(true);
            rateL.setVisible(true);
            rate.setVisible(true);
            max.setVisible(true);
            maxHours.setVisible(true);
        } else if ("Part time".equals(selectedType)) {
            hourL.setText("Hours worked:");
            rateL.setText("Hourly rate:");
            hourL.setVisible(true);
            hour.setVisible(true);
            rateL.setVisible(true);
            rate.setVisible(true);
        } else if ("Full time".equals(selectedType)) {
            hourL.setText("Salary:");
            hourL.setVisible(true);
            hour.setVisible(true);
        }
    }


    @FXML
    void onAdd(ActionEvent event) throws Exception {
        String nameValue = name.getText();
        String typeValue = select.getValue();

        Employee newEmployee = null;
        double salaryValue = 0.0;

        try {
            if ("Full time".equals(typeValue)) {
                double fixedSalary = Double.parseDouble(hour.getText());
                newEmployee = new FullTimeEmployee(nameValue, fixedSalary);
            } else if ("Part time".equals(typeValue)) {
                double hourlyRate = Double.parseDouble(rate.getText());
                int hoursWorked = Integer.parseInt(hour.getText());
                newEmployee = new PartTimeEmployee(nameValue, hourlyRate, hoursWorked);
            } else if ("Contract".equals(typeValue)) {
                double hourlyRate = Double.parseDouble(rate.getText());
                int hoursWorked = Integer.parseInt(hour.getText());
                int maxHour=Integer.parseInt(maxHours.getText());
                newEmployee = new Contractor(nameValue, hourlyRate, maxHour,hoursWorked);
            }


            if (newEmployee != null) {
                salaryValue = newEmployee.calculateSalary();
                newEmployee.setSalary(salaryValue);
                employers.add(newEmployee);
            }



            name.clear();
            hour.clear();
            rate.clear();
            select.setValue(null);
            updateDeviceFieldsVisibility();

        } catch (NumberFormatException e) {
            throw new Exception("Invalid Input");
        }
    }

    private void clearFields() {
        name.clear();
        hour.clear();
        rate.clear();
        select.getSelectionModel().clearSelection();
        updateDeviceFieldsVisibility();
    }
    @FXML
    protected void onListClicked(){
        int id = list.getSelectionModel().getSelectedIndex();
        label.setText(employers.get(id).toString());
    }
    @FXML
    private void onDelete(){
        int id=list.getSelectionModel().getSelectedIndex();
        label.setText(employers.get(id).getName() + " is removed");
        employers.remove(id);
    }



}