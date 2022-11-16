package maciej.gonda.springbootserver.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfVisit {
    @Id
    private Long id;

    @OneToMany(mappedBy = "type")
    private Collection<Visit> visits;

}
