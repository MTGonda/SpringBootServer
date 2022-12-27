package maciej.gonda.springbootserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String imie;
    private String nazwisko;
    private String numertelefonu;
    private String Pesel;
    private Date dataurodzenia;


   // privat Doctor docteor;

    //private User user;

    //private Collection<Visit> visits;

    //private Collection<Allergy> allergies;

    //private Collection<Raport> raports;
}
