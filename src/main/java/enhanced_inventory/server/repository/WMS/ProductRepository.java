package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategories_Id(String categoryId); // find면 optinal
}
