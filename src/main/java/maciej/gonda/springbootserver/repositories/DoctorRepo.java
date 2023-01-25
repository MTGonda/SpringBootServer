package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.print.Doc;
import java.util.Collection;
import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {

    Optional<Doctor>  findByImieAndNazwiskoAndSpecjalizacja(String imie, String nazwisko, String specjalizacja);

    Optional<Doctor> findByNumerAndSpecjalizacja(String numer, String specjalizacja);

}
