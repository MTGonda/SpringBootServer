package maciej.gonda.springbootserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientCreationDTO {

    private String imie;
    private String nazwisko;
    private String numertelefonu;
    private String pesel;
    private String login;
    private LocalDate dataurodzenia;
    private String password;
}
