package maciej.gonda.springbootserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imie;
    private String nazwisko;
    private String numertelefonu;
    private String pesel;
    private Date dataurodzenia;

    @ManyToOne(optional = true)
    private Doctor doctor;

    @OneToOne(optional = false)
    private User user;

    @OneToMany(mappedBy = "patient")
    private Collection<Visit> visits;

    @ManyToMany(mappedBy = "patient")
    private Collection<Allergy> allergies;

    @OneToMany(mappedBy = "patient")
    private Collection<Raport> raports;

}
