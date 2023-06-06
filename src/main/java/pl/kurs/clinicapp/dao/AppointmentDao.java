package pl.kurs.clinicapp.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.clinicapp.model.Appointment;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AppointmentDao extends GenericDao<Appointment,Long> {



}
