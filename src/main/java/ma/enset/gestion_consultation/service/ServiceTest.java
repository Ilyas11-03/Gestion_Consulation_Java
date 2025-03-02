package ma.enset.gestion_consultation.service;

import ma.enset.gestion_consultation.dao.ConsultationDao;
import ma.enset.gestion_consultation.dao.PatientDao;
import ma.enset.gestion_consultation.entities.Patient;

import java.util.List;

public class ServiceTest {

    public static void main(String[] args) {

        ICabinetService service = new CabinetService(new PatientDao(), new ConsultationDao());
//        Patient patient = new Patient();
//        patient.setNom("ABoulkassim");
//        patient.setPrenom("Ilyas");
//        patient.setTel("0611223355");
//        service.addPatient(patient);
//        List<Patient> patients = service.getAllPatients();
//        patients.forEach(patient -> System.out.println(patient));
        Patient patient = service.getPatientById(1L);
        patient.setTel("0622331100");
        service.updatePatient(patient);
//        System.out.println(patient);



    }
}
