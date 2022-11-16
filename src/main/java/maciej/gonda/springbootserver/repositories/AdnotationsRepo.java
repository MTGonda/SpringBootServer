package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Adnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdnotationsRepo extends JpaRepository<Adnotations,Long> {


}
