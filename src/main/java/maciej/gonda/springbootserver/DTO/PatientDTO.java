package maciej.gonda.springbootserver.DTO;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.*;

import java.sql.Date;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String imie;
    private String nazwisko;
    private String numertelefonu;
    private String Pesel;
    private Date dataurodzenia;


    private Doctor doctor;

    private User user;

    private Collection<Visit> visits;

    private Collection<Allergy> allergies;

    private Collection<Raport> raports;
}
