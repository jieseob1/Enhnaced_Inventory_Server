package enhanced_inventory.server.controller.WMS;

import enhanced_inventory.server.domain.WMS.InventoryItem;
import enhanced_inventory.server.service.WMS.InventoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
  private final InventoryService inventoryService;

  public InventoryController(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @GetMapping("/")
  public Page<InventoryItem> list(@RequestParam(required = false) String query, Pageable pageable) {
    return inventoryService.findInventoryItems(query, pageable);
  }

}
