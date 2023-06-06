package pl.kurs.clinicapp.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.dao.AppointmentDao;
import pl.kurs.clinicapp.exceptions.InvalidDataException;
import pl.kurs.clinicapp.model.Appointment;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IService<Appointment> {

    private final AppointmentDao appointmentDao;
    private final IDeserializeService<Appointment> deserializeService;
    private final String textFileName;


    public AppointmentService(AppointmentDao appointmentDao, @Qualifier("appointmentDeserializeService") IDeserializeService<Appointment> deserializeService,@Value("${appointment.path}") String textFileName) {
        this.appointmentDao = appointmentDao;
        this.deserializeService = deserializeService;
        this.textFileName = textFileName;
    }

    @Override
    public void saveAll() throws InvalidDataException {
        List<Appointment> appointmentList = Optional.ofNullable(deserializeService.importFromTxt(textFileName))
                .orElseThrow(() -> new InvalidDataException("Wrong input data"));
        appointmentList.forEach(appointmentDao::save);
    }

}