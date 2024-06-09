package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {
}
