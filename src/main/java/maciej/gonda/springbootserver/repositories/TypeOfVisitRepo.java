package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.TypeOfVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfVisitRepo extends JpaRepository<TypeOfVisit,Long> {

}
