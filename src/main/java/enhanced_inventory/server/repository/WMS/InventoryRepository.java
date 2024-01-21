package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.entity.WMS.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryItem,String> {
}
