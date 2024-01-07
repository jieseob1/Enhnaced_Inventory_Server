package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<InventoryItem,String> {
}
