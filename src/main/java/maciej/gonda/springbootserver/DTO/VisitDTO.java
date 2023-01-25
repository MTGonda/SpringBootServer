package maciej.gonda.springbootserver.DTO;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private Date datawizyty;
    private Time startWizyty;
    private String koniecWizyty;
    private String rodzajWizyty;
    private String opis;



}
