package pl.kurs.clinicapp.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.dao.PatientDao;
import pl.kurs.clinicapp.exceptions.InvalidDataException;
import pl.kurs.clinicapp.model.Patient;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IService<Patient> {

    private final PatientDao patientDao;
    private final IDeserializeService<Patient> deserializeService;
    private final String textFileName;


    public PatientService(PatientDao patientDao, @Qualifier("patientDeserializeService") IDeserializeService<Patient> deserializeService,@Value("${patient.path}") String textFileName) {
        this.patientDao = patientDao;
        this.deserializeService = deserializeService;
        this.textFileName = textFileName;
    }

    @Override
    public void saveAll() throws InvalidDataException {
        List<Patient> patientsList = Optional.ofNullable(deserializeService.importFromTxt(textFileName))
                .orElseThrow(() -> new InvalidDataException("Wrong input data"));
        patientsList.forEach(patientDao::save);
    }

    public Patient getPatientWithAppointments(Long id) throws InvalidDataException {
        return Optional.ofNullable(patientDao.get(id))
                .orElseThrow(() -> new InvalidDataException("Wrong input data"));
    }

}



