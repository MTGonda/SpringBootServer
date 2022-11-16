package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
