package maciej.gonda.springbootserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Patient;
import maciej.gonda.springbootserver.entities.Raport;
import maciej.gonda.springbootserver.entities.TypeOfVisit;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitCreationByPatinetDTO {
    private LocalDateTime datawizyty;

    private String rodzajwizyty;

    private String adresGabinetu;

    private int numerGabinetu;

    private double cena;

    private String opis;

    private Doctor doctor;

    private Patient patient;

    private TypeOfVisit type;
}
