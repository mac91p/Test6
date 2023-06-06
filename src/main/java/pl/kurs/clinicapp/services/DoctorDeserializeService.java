package pl.kurs.clinicapp.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.model.Doctor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("doctorDeserializeService")
public class DoctorDeserializeService implements IDeserializeService {


    public DoctorDeserializeService() {
    }

    private Doctor mapStringToDoctor(String line) {
        String[] data = line.split(" ");
        Doctor doctor = new Doctor();
        doctor.setDoctorId(Long.parseLong(data[0]));
        doctor.setLastName(data[1]);
        doctor.setFirstName(data[2]);
        doctor.setSpecialization(data[3]);
        doctor.setBirthDate(LocalDate.parse(data[4]));
        doctor.setNipNumber(data[5]);
        doctor.setPeselNumber(data[6]);
        return doctor;
    }


    @Override
    public List<Doctor> importFromTxt(String filePath) {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bf.readLine()) != null) {
                doctors.add(mapStringToDoctor(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
