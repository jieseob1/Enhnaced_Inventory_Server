package enhanced_inventory.server.controller.WMS;

import enhanced_inventory.server.domain.WMS.Inventory;
import enhanced_inventory.server.service.WMS.InventoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    /**
     * 1. 재고 현황 조회
     * 3. 재고 추가 및 조정
     * 4. 재고 이동
     * 5. 재고 삭제
     * 6. 재고 이력 조회
     * 7. 창고 내 물품위치 관리
     */
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/create")
    public void createInventory(@RequestBody Inventory inventory) {
        inventoryService.saveInventory(inventory);
    }

    @GetMapping("/all/{page}/{size}")
    public ResponseEntity<Page<Inventory>> getAllInventories(@PathVariable int page,
        @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Inventory> inventories = inventoryService.getAllInventories(pageable);
        return ResponseEntity.ok(inventories);
    }

    @PostMapping("/add-or-update")
    public ResponseEntity<String> addOrUpdateInventory(@RequestParam Long itemId, @RequestParam Long locationId, @RequestParam int quantity) {
        inventoryService.addOrUpdateInventory(itemId, locationId, quantity);
        return ResponseEntity.ok("Inventory updated successfully");
    }

    @PostMapping("/move")
    public ResponseEntity<String> moveInventory(@RequestParam Long fromLocationId, @RequestParam Long toLocationId,
        @RequestParam Long itemId, @RequestParam int quantity) {
        inventoryService.moveInventory(fromLocationId, toLocationId, itemId, quantity);
        return ResponseEntity.ok("Inventory moved successfully");
    }

    @DeleteMapping("/{inventoryId}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long inventoryId) {
        inventoryService.deleteInventory(inventoryId);
        return ResponseEntity.ok("Inventory deleted successfully");
    }
}
