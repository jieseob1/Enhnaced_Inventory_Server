package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {

}
