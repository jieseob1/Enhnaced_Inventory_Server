package enhanced_inventory.server.controller.WMS;

import enhanced_inventory.server.domain.WMS.Inventory;
import enhanced_inventory.server.domain.WMS.Item;
import enhanced_inventory.server.service.WMS.InventoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    // 1. 재고 현황 조회: 실시간 재고 현황 조회 및 재고 정보 확인하는 기능 => 현재 재고 정보들 확인
    // 2. 재고 조정: 재고 변경 => 실제 재고와 시스템 상의 재고를 일치 시키기 위해 재고 조정하는 기능 => 어떻게 해야 하는 거지
    // 3. 재고 이동=> 창고 내에서 재고 이동 또는 창고 간 이동을 관리하는 기능
    // 4. 재고 실사 => 실제 재고 점검 & 시스템 상의 재고와 일치하는지 확인하는 기능
    // 5. 안전 재고 관리: 적정 수준의 재고를 유지하기 위해 안전 재고 설정 및 관리 기능
//  6. 재고 할당 및 예약: 출고 오더에 맞는 재고를 사전에 할당하거나 예약하는 기능
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public void createInventory(@RequestBody Inventory inventory) {
        inventoryService.saveInventory(inventory);
    } // 재고 생성

    @GetMapping
    public List<Inventory> getAllInventories() {
        //1. 재고 현황 조회
        return inventoryService.getAllInventories();
    }

//    @GetMapping("/item/{itemId}")
//    public List<Inventory> getInventoriesByItem(@PathVariable("itemId") Long itemId) { // @PathVariable이란 =>  URL 경로의 일부를 메서드의 파라미터로 바인딩하는 데 사용
//        Item item = new Item(); // This should be fetched from ItemRepository
//        item.setId(itemId);
//        List<Inventory> inventories = inventoryService.getInventoryByItem(item);
//    }

    //재고 조정 => 재고 변경
    @PostMapping("/{inventoryId}/adjust/{newQuantity}")
    public ResponseEntity<Inventory> adjustInventory(@PathVariable("inventoryId") Long inventoryId, @PathVariable("newQuantity") int newQuantity) {
        Inventory inventory = inventoryService.adjustInventory(inventoryId, newQuantity);
        return ResponseEntity.ok(inventory);
    }

//    @PostMapping('/{inventoryId}/allocate/{quantity}')
//    public ResponseEntity<Inventory> allocateInventory(@PathVariable("inventoryId") Long inventoryId, @PathVariable("quantity") int quantity) {
//        Inventory inventory = inventoryService.allocateInventory(inventoryId, quantity);
//        return ResponseEntity.ok(inventory);
//    }
}
