package pl.kurs.clinicapp.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.dao.DoctorDao;
import pl.kurs.clinicapp.exceptions.InvalidDataException;
import pl.kurs.clinicapp.model.Appointment;
import pl.kurs.clinicapp.model.Doctor;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements IService<Doctor> {

    private final DoctorDao doctorDao;
    private final IDeserializeService<Doctor> deserializeService;
    private final String textFileName;


    public DoctorService(DoctorDao doctorDao, @Qualifier("doctorDeserializeService") IDeserializeService<Doctor> deserializeService,@Value("${doctor.path}") String textFileName) {
        this.doctorDao = doctorDao;
        this.deserializeService = deserializeService;
        this.textFileName = textFileName;
    }

    @Override
    public void saveAll() throws InvalidDataException {
        List<Doctor> doctorList = Optional.ofNullable(deserializeService.importFromTxt(textFileName))
                .orElseThrow(() -> new InvalidDataException("Wrong input data"));
        doctorList.forEach(doctorDao::save);
    }

    public LocalDate getNextAvailableAppointmentDate(Long doctorId) throws InvalidDataException {
        Doctor doctor = Optional.ofNullable(doctorDao.get(doctorId)).
                orElseThrow(() -> new InvalidDataException("Doctor not found"));
        LocalDate maxDate = doctor
                .getDoctorAppointments()
                .stream()
                .map(Appointment::getVisitDate)
                .max(LocalDate::compareTo)
                .orElseThrow(() -> new InvalidDataException("No next available appointment date"));
        return maxDate.plusDays(1);
    }

}
