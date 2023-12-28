module org.example.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ProjectClasses;
    opens org.example.bank to javafx.fxml;
    exports org.example.bank;
}