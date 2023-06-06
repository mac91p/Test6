package pl.kurs.clinicapp.services;

import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.model.Patient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("patientDeserializeService")
public class PatientsDeserializerService implements IDeserializeService{


    public PatientsDeserializerService() {
    }

    private Patient mapStringToPatient(String line) {
        String[] data = line.split(" ");
        Patient patient = new Patient();
        patient.setPatientId(Long.parseLong(data[0]));
        patient.setLastName(data[1]);
        patient.setFirstName(data[2]);
        patient.setPeselNumber(data[3]);
        patient.setBirthDate(LocalDate.parse(data[4]));
        return patient;
    }

    @Override
    public List<Patient> importFromTxt(String filePath) {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader bf  = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bf.readLine()) != null) {
                patients.add(mapStringToPatient(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
