package maciej.gonda.springbootserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.*;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientCreationDTO {

    private String imie;
    private String nazwisko;
    private String numertelefonu;
    private String pesel;
    private String login;
    private Date dataurodzenia;
    private String password;
}
