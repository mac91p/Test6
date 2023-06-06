package pl.kurs.clinicapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Long id;
    private Long patientId;
    private String lastName;
    private String firstName;
    private String peselNumber;
    private LocalDate birthDate;
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "patient")
    private List<Appointment> patientAppointment = new ArrayList<>();

    public Patient() {
    }

    public Patient(Long patientId, String lastName, String firstName, String peselNumber, LocalDate birthDate) {
        this.patientId = patientId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.peselNumber = peselNumber;
        this.birthDate = birthDate;
    }

    public List<Appointment> getPatientAppointment() {
        return patientAppointment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(patientId, patient.patientId) && Objects.equals(lastName, patient.lastName) && Objects.equals(firstName, patient.firstName) && Objects.equals(peselNumber, patient.peselNumber) && Objects.equals(birthDate, patient.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, lastName, firstName, peselNumber, birthDate);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", peselNumber='" + peselNumber + '\'' +
                ", birthDate=" + birthDate +
                ", patientAppointment=" + patientAppointment +
                '}';
    }
}
