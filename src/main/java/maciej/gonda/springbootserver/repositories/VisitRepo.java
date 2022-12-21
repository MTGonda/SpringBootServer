package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface VisitRepo extends JpaRepository<Visit,Long> {
    Optional <Visit> findByDatawizyty(LocalDateTime datawizyty);
}
