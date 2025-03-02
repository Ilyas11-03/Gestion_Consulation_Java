package ma.enset.gestion_consultation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import ma.enset.gestion_consultation.dao.ConsultationDao;
import ma.enset.gestion_consultation.dao.PatientDao;
import ma.enset.gestion_consultation.entities.Consultation;
import ma.enset.gestion_consultation.entities.Patient;
import ma.enset.gestion_consultation.service.CabinetService;
import ma.enset.gestion_consultation.service.ICabinetService;

import javafx.scene.control.TextArea;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {
    @FXML private DatePicker dateConsultation;
    @FXML private ComboBox<Patient> comboPatient;
    @FXML private TextArea textFieldDescription;
    private ICabinetService cabinetService;
    private ObservableList<Patient> patients = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new PatientDao(), new ConsultationDao());
        comboPatient.setItems(patients);
        patients.setAll(cabinetService.getAllPatients());

    }

    public void addConsultation() {
        Consultation consultation = new Consultation();
        consultation.setDateConsultation(Date.valueOf(dateConsultation.getValue()));
        consultation.setDescription(textFieldDescription.getText());
        consultation.setPatient(comboPatient.getValue());
        cabinetService.addConsultation(consultation);


    }

    public void deleteConsultation(ActionEvent actionEvent) {
    }
}
