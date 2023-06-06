package pl.kurs.clinicapp.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.kurs.clinicapp.exceptions.InvalidDataException;
import pl.kurs.clinicapp.model.Patient;
import pl.kurs.clinicapp.services.AppointmentService;
import pl.kurs.clinicapp.services.DoctorService;
import pl.kurs.clinicapp.services.PatientService;
import java.time.LocalDate;


@ComponentScan(basePackages = "pl.kurs")
public class Main {
    public static void main(String[] args) throws InvalidDataException {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        DoctorService doctorService =  ctx.getBean(DoctorService.class);
        doctorService.saveAll();

        PatientService patientService = ctx.getBean(PatientService.class);
        patientService.saveAll();

        AppointmentService appointmentService = ctx.getBean(AppointmentService.class);
        appointmentService.saveAll();


        LocalDate nextDate = doctorService.getNextAvailableAppointmentDate(1L);
        System.out.println(nextDate);

        Patient patient = patientService.getPatientWithAppointments(1l);
        patient.getPatientAppointment().forEach(System.out::println);


    }
}
