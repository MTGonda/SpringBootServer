package maciej.gonda.springbootserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.Doctor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecializationDTO {
    private String nazwa;
}
