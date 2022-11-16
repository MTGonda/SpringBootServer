package maciej.gonda.springbootserver.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    @Id
    private Long id;
    private LocalDateTime datawizyty;
    private String rodzajwizyty;
    private String adresGabinetu;
    private int numerGabinetu;
    private double cena;

    private String opis;

    @ManyToOne(optional = false)
    private Doctor doctor;

    @OneToOne(optional = false)
    private Raport raport;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private TypeOfVisit type;

}
