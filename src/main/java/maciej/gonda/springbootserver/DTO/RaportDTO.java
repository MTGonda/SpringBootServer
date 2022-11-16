package maciej.gonda.springbootserver.DTO;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Patient;
import maciej.gonda.springbootserver.entities.Visit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaportDTO {
    private String tresc;


    private Visit visit;

    private Patient patient;

    private Doctor doctor;
}
