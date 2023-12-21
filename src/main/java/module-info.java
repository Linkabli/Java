module org.example.bank {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bank to javafx.fxml;
    exports org.example.bank;
}