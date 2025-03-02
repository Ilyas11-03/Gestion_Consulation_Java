package ma.enset.gestion_consultation.entities;

import java.util.Date;

public class Consultation {
    private long id;
    private Date dateConsultation;
    private String description;
    private Patient patient;

    public Consultation() {
    }

    public Consultation(long id, Date dateConsultation, String description, Patient patient) {
        this.id = id;
        this.dateConsultation = dateConsultation;
        this.description = description;
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }
    public java.sql.Date getDateConsultation() {
        return (java.sql.Date) dateConsultation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
