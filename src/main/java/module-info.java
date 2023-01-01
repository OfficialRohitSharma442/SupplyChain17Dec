module com.example.supplychain17dec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychain17dec to javafx.fxml;
    exports com.example.supplychain17dec;
}