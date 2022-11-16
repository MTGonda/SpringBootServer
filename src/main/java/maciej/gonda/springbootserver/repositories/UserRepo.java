package maciej.gonda.springbootserver.repositories;

import maciej.gonda.springbootserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
