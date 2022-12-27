package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecializationRepo extends JpaRepository<Specialization,Long> {
    Optional<Specialization> findSpecializationByNazwa(String nazwa);
}
