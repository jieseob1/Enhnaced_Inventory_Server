package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.InventoryItem;
import enhanced_inventory.server.repository.WMS.InventoryRepository;
import enhanced_inventory.server.service.Specification.InventorySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
  private final InventoryRepository inventoryRepository;

  public InventoryService(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  //have to do Pagination
  public Optional<List<InventoryItem>> findAllInventories() {
    return Optional.of(inventoryRepository.findAll());
  }

  public Page<InventoryItem> findInventoryItems(String query, Pageable pageable) {
    if (query == null || query.isEmpty()) {
      return inventoryRepository.findAll(pageable);
    } else {
      Specification<InventoryItem> spec = Specification.where(InventorySpecification.nameContains(query))
          .or(InventorySpecification.locationContains(query));
      return inventoryRepository.findAll(spec, pageable);
    }
  }
}
