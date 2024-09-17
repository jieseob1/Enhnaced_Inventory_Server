package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaSpecificationExecutor => 쿼리 조건 다루기 id와 name등으로 검색하기 위함
public interface InventoryRepository extends JpaRepository<Inventory,Long>{
}
