package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.InventoryItem;
import enhanced_inventory.server.repository.WMS.InventoryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class InventoryService {
  private final InventoryRepository inventoryRepository;

  public InventoryService(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

}
