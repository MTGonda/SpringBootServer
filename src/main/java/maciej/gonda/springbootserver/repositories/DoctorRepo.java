package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {

    Optional<Doctor>  findByImieAndNazwisko(String imie, String nazwisko);
}
