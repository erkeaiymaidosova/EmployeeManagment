module com.example.employeemanagment1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.employeemanagment1 to javafx.fxml;
    exports com.example.employeemanagment1;
}