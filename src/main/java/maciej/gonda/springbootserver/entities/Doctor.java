package maciej.gonda.springbootserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imie;
    private String nazwisko;
    private String numerTelefonu;
    private String adresGabinetu;
    private String numer;
    private String specjalizacja; //TODO nie jest z tej wersji (usunąć w razie problemów)




    @OneToMany(mappedBy = "doctor")
    private Collection<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    private Collection<Visit> visits;

    @OneToOne(optional = true)
    private User user;


    @OneToMany(mappedBy = "doctor")
    private Collection<Raport> raports;


    @Override
    public String toString() {
        return "Doctor{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ",specjalizacja='" + specjalizacja + '\'' +
                ", numer=" + numer +'\''+
        '}';
    }
}
