package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
z