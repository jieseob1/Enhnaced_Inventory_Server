package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
