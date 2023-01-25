package maciej.gonda.springbootserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Raport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tresc;

    @OneToOne(mappedBy = "raport", optional = false)
    private Visit visit;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private Doctor doctor;

    @Override
    public String toString() {
        return "Raport{" +
                "tresc='" + tresc + '\'' +
                ", visit=" + visit +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
