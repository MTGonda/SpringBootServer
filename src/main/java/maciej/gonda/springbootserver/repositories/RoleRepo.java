package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Long> {

    Optional<Role> findRoleByName(String name);

}
