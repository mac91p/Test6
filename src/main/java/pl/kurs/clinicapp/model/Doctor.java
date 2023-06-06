package pl.kurs.clinicapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long id;
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private LocalDate birthDate;
    private String nipNumber;
    private String peselNumber;
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "doctor")
    private List<Appointment> doctorAppointments = new ArrayList<>();


    public Doctor() {
    }

    public Doctor(Long doctorId, String firstName, String lastName, String specialization, LocalDate birthDate, String nipNumber, String peselNumber) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.birthDate = birthDate;
        this.nipNumber = nipNumber;
        this.peselNumber = peselNumber;
    }


    public List<Appointment> getDoctorAppointments() {
        return doctorAppointments;
    }

    public void setDoctorAppointments(List<Appointment> doctorAppointments) {
        this.doctorAppointments = doctorAppointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNipNumber() {
        return nipNumber;
    }

    public void setNipNumber(String nipNumber) {
        this.nipNumber = nipNumber;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) && Objects.equals(doctorId, doctor.doctorId) && Objects.equals(firstName, doctor.firstName) && Objects.equals(lastName, doctor.lastName) && Objects.equals(specialization, doctor.specialization) && Objects.equals(birthDate, doctor.birthDate) && Objects.equals(nipNumber, doctor.nipNumber) && Objects.equals(peselNumber, doctor.peselNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorId, firstName, lastName, specialization, birthDate, nipNumber, peselNumber);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                ", doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", nipNumber='" + nipNumber + '\'' +
                ", peselNumber='" + peselNumber + '\'' +
                '}';
    }
}
