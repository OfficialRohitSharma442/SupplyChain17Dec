module com.example.supplychain17dec {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.supplychain17dec to javafx.fxml;
    exports com.example.supplychain17dec;
}