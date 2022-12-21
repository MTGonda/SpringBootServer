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

    @OneToMany(mappedBy = "doctor")
    private Collection<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    private Collection<Visit> visits;

    @OneToOne(optional = false)
    private User user;

    @ManyToMany(mappedBy = "doctors")
    private Collection<Specialization> specializations;

    @OneToMany(mappedBy = "doctor")
    private Collection<Raport> raports;

}
