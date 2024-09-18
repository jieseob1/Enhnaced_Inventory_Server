package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

}
