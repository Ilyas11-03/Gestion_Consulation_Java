package ma.enset.gestion_consultation.service;

import ma.enset.gestion_consultation.entities.Consultation;
import ma.enset.gestion_consultation.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface ICabinetService {

    void addPatient(Patient patient);
    void deletePatient(Patient patient);
    void updatePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    List<Patient> searchPatientsByQuery(String query) throws SQLException;

    void addConsultation(Consultation consultation);
    void deleteConsultation(Consultation consultation);
    void updateConsultation(Consultation consultation);
    List<Consultation> getAllConsultations();
    Consultation getConsultationById(Long id);


}
