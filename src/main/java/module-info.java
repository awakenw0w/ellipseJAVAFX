module com.example.ellipsejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ellipsejavafx to javafx.fxml;
    exports com.example.ellipsejavafx;
}