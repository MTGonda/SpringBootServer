package maciej.gonda.springbootserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateRaportFromVisitDTO {

// lekarz wprowadzany jest na podstawie konta które było wprowadzone
// lekarz jest wprowadzony adres gabinetu na podstawie tego kto jest zalogowany

   // private VisitCreationByPatientDTO visitCreationByPatientDTO;

    private Date dataodbywanejwizyty;
    private Time godzinaodbywanejwizyty;
    private Time koniecodbywanejwizyty;
    private String rodzajodbywanejwizyty;
    private String numerpatientPESEL;
    private String prowadzacyNumerLekarza;
    private String imieLekarzaprowadzacego;
    private String nazwiskoLekarzaprowadzacego;
    private String specjalizacjaLekarzaprowadzacego;
    private String tresc;

}
