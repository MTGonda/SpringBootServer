package maciej.gonda.springbootserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VisitTakePlaceDTO {

    private Date datawizyty;
    private Time godzinawizyty;
}
