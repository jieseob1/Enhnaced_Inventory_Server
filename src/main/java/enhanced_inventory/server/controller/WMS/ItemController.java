package enhanced_inventory.server.controller.WMS;

import enhanced_inventory.server.domain.WMS.Item;
import enhanced_inventory.server.service.WMS.ItemService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

  private ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Item>> getAllItems() {
    List<Item> items = itemService.getAllItemsByLIst();
    return ResponseEntity.ok(items);
  }
}
