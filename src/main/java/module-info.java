module ma.enset.gestion_consultation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires java.desktop;


    opens ma.enset.gestion_consultation.controllers to javafx.fxml;
    opens ma.enset.gestion_consultation.entities to javafx.base;
    exports ma.enset.gestion_consultation;
}