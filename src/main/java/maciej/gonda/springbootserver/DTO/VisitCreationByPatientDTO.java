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
public class VisitCreationByPatientDTO {
    private Date datawizyty;
    private Time godzinawizyty;
    private Time koniecwizyty;
    private String rodzajwizyty;
    private String patientPESEL;
    private String numerLekarza;
    private String specjalizacjaLekarza;
}
