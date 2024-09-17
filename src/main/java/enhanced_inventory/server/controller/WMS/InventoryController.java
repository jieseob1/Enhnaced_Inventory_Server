package enhanced_inventory.server.controller.WMS;

import enhanced_inventory.server.domain.WMS.Inventory;
import enhanced_inventory.server.service.WMS.InventoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public void createInventory(@RequestBody Inventory inventory) {
        inventoryService.saveInventory(inventory);
    }

    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

//    @GetMapping("/item/{itemId}")
//    public List<Inventory> getInventoriesByItem(@PathVariable("itemId") Long itemId) { // @PathVariable이란 =>  URL 경로의 일부를 메서드의 파라미터로 바인딩하는 데 사용
//        Item item = new Item(); // This should be fetched from ItemRepository
//        item.setId(itemId);
//        List<Inventory> inventories = inventoryService.getInventoryByItem(item);
//    }
}
