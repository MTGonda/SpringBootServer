package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    Optional<Patient>findPatientByPesel(String pesel);



}
