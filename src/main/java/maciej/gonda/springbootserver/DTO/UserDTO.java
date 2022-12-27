package maciej.gonda.springbootserver.DTO;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import maciej.gonda.springbootserver.entities.Doctor;
import maciej.gonda.springbootserver.entities.Patient;
import maciej.gonda.springbootserver.entities.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String login;
    private String password;
    //private Role role;

}
