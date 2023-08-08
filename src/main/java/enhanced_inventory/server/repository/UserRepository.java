package enhanced_inventory.server.repository;

import enhanced_inventory.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
