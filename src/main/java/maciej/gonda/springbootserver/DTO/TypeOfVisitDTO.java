package maciej.gonda.springbootserver.DTO;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.Visit;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfVisitDTO {
//TODO  do usunięcia (klasa nie jest potrzebna),( visual Paradigm Diagram klas)!!
    private Collection<Visit> visits;
}
