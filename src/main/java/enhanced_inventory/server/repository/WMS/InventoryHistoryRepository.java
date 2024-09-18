package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.InventoryHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryHistoryRepository extends JpaRepository<InventoryHistory, Long> {
}
