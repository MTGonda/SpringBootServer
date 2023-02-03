package maciej.gonda.springbootserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateRaportFromVisitDTO {

    // lekarz wprowadzany jest na podstawie konta które było wprowadzone
// lekarz jest wprowadzony adres gabinetu na podstawie tego kto jest zalogowany
    private VisitCreationByPatientDTO visitCreationByPatientDTO;
    private String tresc;

  }
