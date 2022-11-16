package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepo extends JpaRepository<Allergy,Long> {
}
