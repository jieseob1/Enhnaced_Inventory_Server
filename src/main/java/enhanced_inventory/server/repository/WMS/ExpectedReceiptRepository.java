package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.ExpectedReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpectedReceiptRepository extends JpaRepository<ExpectedReceipt, Long> {
}
