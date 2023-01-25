package maciej.gonda.springbootserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datawizyty;
    private Time startwizyty;
    private Time koniecwizyty;
    private String rodzajwizyty;

    private String opis;

    @ManyToOne(optional = false)
    private Doctor doctor;

    @OneToOne(optional = true)
    private Raport raport;

    @ManyToOne(optional = true)
    private Patient patient;

    @ManyToOne(optional = true)
    private TypeOfVisit type;

    @Override
    public String toString() {
        return "Visit{" +
                "datawizyty=" + datawizyty +
                ", startwizyty=" + startwizyty +
                ", koniecwizyty=" + koniecwizyty +
                ", rodzajwizyty='" + rodzajwizyty + '\'' +
                ", opis='" + opis + '\'' +
                ", doctor=" + doctor +
                ", raport=" + raport +
                ", patient=" + patient +
                ", type=" + type +
                '}';
    }
}
