package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Patient;
import maciej.gonda.springbootserver.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

public interface VisitRepo extends JpaRepository<Visit,Long> {
    Optional <Visit> findByDatawizytyAndStartwizytyAndDoctor(Date datawizyty, Time godzinawizyty, Doctor doctor);
    Optional <Visit> findByDatawizytyAndStartwizytyAndPatient(Date datawizyty, Time godzinawizyty, Patient patient);
}
