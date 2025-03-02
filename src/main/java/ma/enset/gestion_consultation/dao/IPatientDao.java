package ma.enset.gestion_consultation.dao;

import ma.enset.gestion_consultation.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface IPatientDao extends Dao<Patient, Long>{

    List<Patient> searchByQuery(String query) throws SQLException;
}
