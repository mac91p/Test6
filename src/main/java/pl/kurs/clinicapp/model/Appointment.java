package pl.kurs.clinicapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_appointment")
    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDate visitDate;
    @ManyToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId",insertable = false, updatable = false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "patientId", insertable = false, updatable = false)
    private Patient patient;

    public Appointment() {
    }

    public Appointment(Long doctorId, Long patientId, LocalDate visitDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.visitDate = visitDate;
    }

    public Appointment(Long doctorId, Long patientId, LocalDate visitDate, Doctor doctor, Patient patient) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.visitDate = visitDate;
        this.doctor = doctor;
        this.patient = patient;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment visit = (Appointment) o;
        return Objects.equals(id, visit.id) && Objects.equals(doctorId, visit.doctorId) && Objects.equals(patientId, visit.patientId) && Objects.equals(visitDate, visit.visitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorId, patientId, visitDate);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", visitDate=" + visitDate +
                '}';
    }
}
