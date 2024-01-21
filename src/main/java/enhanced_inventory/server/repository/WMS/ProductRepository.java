package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.entity.WMS.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategories_Id(String categoryId); // find면 optinal
}
