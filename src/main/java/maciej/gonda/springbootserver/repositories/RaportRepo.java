package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Raport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaportRepo extends JpaRepository<Raport,Long> {

    Optional<Raport> findRaportByDoctor_ImieAndDoctor_NazwiskoAndPatient_Pesel(String doctor_imie, String doctor_nazwisko, String patient_pesel);
    Optional<Raport> findRaportByPatient_ImieAndPatient_NazwiskoAndPatient_Pesel(String patient_imie, String patient_nazwisko, String patient_pesel);
}
