package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}
