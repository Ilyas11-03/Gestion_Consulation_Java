package ma.enset.gestion_consultation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestion_consultation.dao.ConsultationDao;
import ma.enset.gestion_consultation.dao.PatientDao;
import ma.enset.gestion_consultation.entities.Patient;
import ma.enset.gestion_consultation.service.CabinetService;
import ma.enset.gestion_consultation.service.ICabinetService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    public Label labelSuccess;
    @FXML  private TextField textFieldNom;
    @FXML  private TextField textFieldPrenom;
    @FXML  private TextField textFieldTel;
    @FXML  private TextField textfieldSearch;
    @FXML  private TableView<Patient> tablePatients;
    @FXML  private TableColumn<Patient, Long> columnId;
    @FXML  private TableColumn<Patient, String> columnNom;
    @FXML  private TableColumn<Patient, String> columnPrenom;
    @FXML  private TableColumn<Patient, String> columnTel;
    private ICabinetService iCabinetService;
    private Patient editedPatient;
    private ObservableList<Patient> patients = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iCabinetService = new CabinetService(new PatientDao(), new ConsultationDao());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));

        patients.setAll(iCabinetService.getAllPatients());
        tablePatients.setItems(patients);
        loadPatients();
        textfieldSearch.textProperty().addListener((observableValue, oldValue, newValue) ->
                {
                    try {
                        patients.setAll(iCabinetService.searchPatientsByQuery(newValue));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                );
        tablePatients.getSelectionModel().selectedItemProperty().addListener((observableValue, oldPatient, newPatient) ->{
            if (newPatient != null){
                textFieldNom.setText(newPatient.getNom());
                textFieldPrenom.setText(newPatient.getPrenom());
                textFieldTel.setText(newPatient.getTel());
                editedPatient=newPatient;
            }
        } );

    }
    public void addPatient() {
        Patient patient = new Patient();
        patient.setNom(textFieldNom.getText());
        patient.setPrenom(textFieldPrenom.getText());
        patient.setTel(textFieldTel.getText());
        iCabinetService.addPatient(patient);
        patients.setAll(iCabinetService.getAllPatients());

    }
    public void delPatient(){
        Patient patient = tablePatients.getSelectionModel().getSelectedItem();
        iCabinetService.deletePatient(patient);
        loadPatients();
        labelSuccess.setText("Le patient a été supprimé avec succès.");
    }
    private void loadPatients() {
        patients.setAll(iCabinetService.getAllPatients());
    }

    public void updatePatient(ActionEvent actionEvent) {
        editedPatient.setNom(textFieldNom.getText());
        editedPatient.setPrenom(textFieldPrenom.getText());
        editedPatient.setTel(textFieldTel.getText());

        iCabinetService.updatePatient(editedPatient);
        loadPatients();
    }
}
