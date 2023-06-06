package pl.kurs.clinicapp.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.clinicapp.model.Patient;
import javax.transaction.Transactional;


@Repository
@Transactional
public class PatientDao extends GenericDao<Patient, Long> {


}
