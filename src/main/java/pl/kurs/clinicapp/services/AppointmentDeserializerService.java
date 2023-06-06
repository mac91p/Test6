package pl.kurs.clinicapp.services;

import org.springframework.stereotype.Service;
import pl.kurs.clinicapp.model.Appointment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("appointmentDeserializeService")
public class AppointmentDeserializerService implements IDeserializeService {

    public AppointmentDeserializerService() {
    }

    private Appointment mapStringToAppointment(String line) {
        String[] data = line.split(" ");
        Appointment visit = new Appointment();
        visit.setDoctorId(Long.parseLong(data[0]));
        visit.setPatientId(Long.parseLong(data[1]));
        visit.setVisitDate(LocalDate.parse(data[2]));
        return visit;
    }


    @Override
    public List<Appointment> importFromTxt(String filePath) {
        List<Appointment> appointments = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bf.readLine()) != null) {
                appointments.add(mapStringToAppointment(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
