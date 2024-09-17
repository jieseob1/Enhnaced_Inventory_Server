package enhanced_inventory.server.service.Specification;

import enhanced_inventory.server.domain.WMS.Inventory;
import org.springframework.data.jpa.domain.Specification;

public class InventorySpecification {
  public static Specification<Inventory> nameContains(String query) {
    return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("product").get("name"), "%" + query + "%");
  }

  public static Specification<Inventory> locationContains(String query) {
    return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("location"), "%" + query + "%");
  }
}