package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.Inventory;
import enhanced_inventory.server.repository.WMS.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
  // 1. 재고 현황 조회: 실시간 재고 현황 조회 및 재고 정보 확인하는 기능 => 현재 재고 정보들 확인
  // 2. 재고 조정: 재고 변경 => 실제 재고와 시스템 상의 재고를 일치 시키기 위해 재고 조정하는 기능 => 어떻게 해야 하는 거지
  // 3. 재고 이동=> 창고 내에서 재고 이동 또는 창고 간 이동을 관리하는 기능
  // 4. 재고 실사 => 실제 재고 점검 & 시스템 상의 재고와 일치하는지 확인하는 기능
  // 5. 안전 재고 관리: 적정 수준의 재고를 유지하기 위해 안전 재고 설정 및 관리 기능
//  6. 재고 할당 및 예약: 출고 오더에 맞는 재고를 사전에 할당하거나 예약하는 기능
  private final InventoryRepository inventoryRepository;

  public InventoryService(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  //have to do Pagination
  public void saveInventory(Inventory inventory) {
      inventoryRepository.save(inventory);
  }

  public List<Inventory> getAllInventories() {
      return inventoryRepository.findAll();
  }
  public Inventory getInventoryById(Long id) {
      return inventoryRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id" + id));
  }

//    public List<Inventory> getInventoriesByItem(Item item) {
//        return inventoryRepository.findByItem(item); // 다대일 => 여러개의 item들로, 하나의 재고(?)
//    }

    @Transactional
    public Inventory adjustInventory(Long inventoryId, int newQuantity) {
      //재고 고정
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id " + inventoryId));
        inventory.setQuantity(newQuantity);
        inventory.setAvailableQuantity(newQuantity - inventory.getAllocatedQuantity());
        return inventoryRepository.save(inventory);


    }
}
