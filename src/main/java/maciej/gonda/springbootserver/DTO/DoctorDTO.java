package maciej.gonda.springbootserver.DTO;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.*;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private String imie;
    private String nazwisko;
    private String numerTelefonu;


    private Collection<Patient> patients;

    private Collection<Visit> visits;

    private User user;

    private Collection<Specialization> specializations;

    private Collection<Raport> raports;
}
