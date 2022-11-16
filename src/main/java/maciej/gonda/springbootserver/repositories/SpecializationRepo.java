package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepo extends JpaRepository<Specialization,Long> {
}
