package ma.enset.gestion_consultation.dao;


import ma.enset.gestion_consultation.entities.Consultation;

public interface IConsultationDao extends Dao<Consultation, Long>{

    void create(IConsultationDao iConsultationDao);

    void delete(IConsultationDao iConsultationDao);

    void update(IConsultationDao iConsultationDao);
}
