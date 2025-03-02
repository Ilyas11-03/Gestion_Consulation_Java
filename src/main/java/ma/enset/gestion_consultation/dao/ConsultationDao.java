package ma.enset.gestion_consultation.dao;

import ma.enset.gestion_consultation.entities.Consultation;
import ma.enset.gestion_consultation.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDao implements IConsultationDao {

    @Override
    public void create(Consultation consultation) throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("Insert Into CONSULTATION(DATE_CONSULTATION,DESCRIPTION,ID_PATIENT)" + "VALUES(?,?,?) ");

        pstm.setDate(1, consultation.getDateConsultation());
        pstm.setString(2, consultation.getDescription());
        pstm.setLong(3, consultation.getPatient().getId());
        pstm.executeUpdate();
    }
    List<Consultation> consultations = new ArrayList<>();



    @Override
    public void delete(Consultation consultation) throws SQLException {

    }

    @Override
    public void update(Consultation consultation) throws SQLException {

    }

    @Override
    public List<Consultation> findAll() throws SQLException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM CONSULTATION ");
        ResultSet rs =  pstm.executeQuery();
        List<Consultation> consultations = new ArrayList<>();

        while (rs.next()) {
            Consultation consultation = new Consultation();
            consultation.setId(rs.getLong("ID_CONSULTATION"));
            consultation.setDateConsultation(rs.getDate("DATE_CONSULTATION"));
            consultation.setDescription(rs.getString("DESCRIPTION"));
            consultation.setPatient(new Patient());
            consultations.add(consultation);

        }
        return consultations;
    }

    @Override
    public Consultation findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void create(IConsultationDao iConsultationDao) {

    }

    @Override
    public void delete(IConsultationDao iConsultationDao) {

    }

    @Override
    public void update(IConsultationDao iConsultationDao) {

    }
}
