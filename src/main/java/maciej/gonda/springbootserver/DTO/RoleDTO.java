package maciej.gonda.springbootserver.DTO;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.User;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private String name;
    private String description;

}
