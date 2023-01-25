package maciej.gonda.springbootserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String imie;
    private String nazwisko;
    private String numertelefonu;
    private String Pesel;
    private LocalDate dataurodzenia;



}
