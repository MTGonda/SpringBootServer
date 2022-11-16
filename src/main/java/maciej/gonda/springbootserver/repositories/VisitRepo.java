package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepo extends JpaRepository<Visit,Long> {
}
