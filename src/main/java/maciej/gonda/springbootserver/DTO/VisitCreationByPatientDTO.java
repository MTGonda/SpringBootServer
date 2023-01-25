package maciej.gonda.springbootserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitCreationByPatientDTO {
    private Date datawizyty;
    private Time godzinawizyty;
    private Time koniecwizyty;
    private String rodzajwizyty;
    private String patientPESEL;
    private String numerlekarza;
    private String imieLekarza;
    private String nazwiskoLekarza;
    private String specjalizacjaLekarza;
}
