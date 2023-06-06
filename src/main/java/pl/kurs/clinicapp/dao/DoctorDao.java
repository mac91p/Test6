package pl.kurs.clinicapp.dao;


import org.springframework.stereotype.Repository;
import pl.kurs.clinicapp.model.Doctor;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DoctorDao extends GenericDao<Doctor, Long> {
}
