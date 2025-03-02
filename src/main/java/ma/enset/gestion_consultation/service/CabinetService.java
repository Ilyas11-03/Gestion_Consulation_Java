package ma.enset.gestion_consultation.service;

import ma.enset.gestion_consultation.dao.IConsultationDao;
import ma.enset.gestion_consultation.dao.IPatientDao;
import ma.enset.gestion_consultation.entities.Consultation;
import ma.enset.gestion_consultation.entities.Patient;
import java.sql.SQLException;
import java.util.List;

public class CabinetService implements ICabinetService {

    private IPatientDao patientDao;
    private IConsultationDao consultationDao;

    public CabinetService(IPatientDao patientDao, IConsultationDao consultationDao) {
        this.patientDao = patientDao;
        this.consultationDao = consultationDao;
    }

    @Override
    public void addPatient(Patient patient) {
        try {
            patientDao.create(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deletePatient(Patient patient) {
        try {
            patientDao.delete(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePatient(Patient patient) {
        try {
            patientDao.update(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = null;
        try {
            patients = patientDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public Patient getPatientById(Long id) {
        Patient patient = null;
        try {
            patient = patientDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public List<Patient> searchPatientsByQuery(String query) throws SQLException {
        return patientDao.searchByQuery(query);
    }


    @Override
    public void addConsultation(Consultation consultation) {
        try {
            consultationDao.create(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteConsultation(Consultation consultation) {

    }

    @Override
    public void updateConsultation(Consultation consultation) {

    }

    @Override
    public List<Consultation> getAllConsultations() {
        return List.of();
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return null;
    }
}
