package enhanced_inventory.server.repository;

import enhanced_inventory.server.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
