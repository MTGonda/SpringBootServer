package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Patient;
import maciej.gonda.springbootserver.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;


import java.sql.Date;

import java.util.Collection;
import java.util.Optional;

public interface VisitRepo extends JpaRepository<Visit,Long> {
    Collection<Visit> findAllByPatientAndDatawizyty(Patient patient, Date datawizyty);
    Collection<Visit> findAllByDoctorAndDatawizyty(Doctor doctor, Date datawizyty);

    Optional<Visit> findByPatientAndDatawizyty(Patient patient, Date datawizyty);
    Optional<Visit>findByDoctorAndDatawizyty(Doctor doctor, Date datawizyty);

}
