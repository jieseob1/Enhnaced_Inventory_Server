package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.InventoryItem;
import enhanced_inventory.server.repository.WMS.InventoryRepository;

import java.util.List;
import java.util.Optional;

public class InventoryService {
  private final InventoryRepository inventoryRepository;

  public InventoryService(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  //have to do Pagination
  public Optional<List<InventoryItem>> findAllInventories() {
    return Optional.of(inventoryRepository.findAll());
  }

}
