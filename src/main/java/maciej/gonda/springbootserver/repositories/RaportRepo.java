package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Raport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaportRepo extends JpaRepository<Raport,Long> {

}
