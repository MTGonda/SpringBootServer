package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
}
