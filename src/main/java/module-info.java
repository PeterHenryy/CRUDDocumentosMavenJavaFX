module inf.frohlich.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens inf.pedro.demo.controller to javafx.fxml;

    exports inf.pedro.demo;
}