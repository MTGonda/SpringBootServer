package maciej.gonda.springbootserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.Patient;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergyDTO {
    private String opis;
    private Collection<Patient> patient;
}
