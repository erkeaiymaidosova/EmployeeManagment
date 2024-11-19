package com.example.employeemanagment1;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Button add;

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
    private ComboBox<String> select;
    ObservableList<Employee> employers = FXCollections.observableArrayList();
    
    @FXML
    void onAdd(ActionEvent event) {

    }
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
    private void updateDeviceFieldsVisibility() {
        hourL.setVisible(false);
        rateL.setVisible(false);
        rate.setVisible(false);
        hour.setVisible(false);
        if (select.getValue() != null && select.getValue().equals("Contract")){
            hourL.setText("Max hours:");
            rateL.setText("Hourly rate:");
            hour.setVisible(true);
            hourL.setVisible(true);
            rate.setVisible(true);
            rateL.setVisible(true);
        }
        if (select.getValue() != null && select.getValue().equals("Part time")){
            hourL.setText("Hours worked:");
            rateL.setText("Hourly rate:");
            hour.setVisible(true);
            hourL.setVisible(true);
            rate.setVisible(true);
            rateL.setVisible(true);
        }
    }
}