package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.Inventory;
import enhanced_inventory.server.domain.WMS.InventoryHistory;
import enhanced_inventory.server.domain.WMS.Item;
import enhanced_inventory.server.domain.WMS.Location;
import enhanced_inventory.server.domain.enums.InventoryHistoryStatus;
import enhanced_inventory.server.repository.WMS.InventoryHistoryRepository;
import enhanced_inventory.server.repository.WMS.InventoryRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  private final InventoryHistoryRepository inventoryHistoryRepository;

  public InventoryService(InventoryRepository inventoryRepository,
      InventoryHistoryRepository inventoryHistoryRepository) {
    this.inventoryRepository = inventoryRepository;
    this.inventoryHistoryRepository = inventoryHistoryRepository;
  }

  @Transactional
  public void addOrUpdateInventory(Long itemId, Long locationId, int quantity) {
    // 재고 추가 및 조정
    Inventory inventory = inventoryRepository.findByItemIdAndLocationId(itemId, locationId)
        .orElse(new Inventory());

    inventory.setItem(new Item(itemId));
    inventory.setLocation(new Location(locationId));
    inventory.setQuantity(inventory.getQuantity() + quantity);
    inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);

    saveInventory(inventory);
    saveInventoryHistory(inventory, "ADD", quantity);
  }

  private void saveInventoryHistory(Inventory inventory, String action, int quantity) {
    //재고 이력 저장
    InventoryHistory inventoryHistory = new InventoryHistory();
    inventoryHistory.setInventory(inventory);
    inventoryHistory.setChangeDate(LocalDateTime.now());
    inventoryHistory.setChangeType(InventoryHistoryStatus.ADD);
    inventoryHistory.setChangeQuantity(quantity);

    inventoryHistoryRepository.save(inventoryHistory);
  }

  //have to do Pagination
  public void saveInventory(Inventory inventory) {
    inventoryRepository.save(inventory);
  }

  public Page<Inventory> getAllInventories(Pageable pageable) {
    return inventoryRepository.findAll(pageable);
  }

  @Transactional
  public void moveInventory(Long fromLocationId, Long toLocationId, Long itemId, int quantity) {
    Inventory fromInventory = inventoryRepository.findByItemIdAndLocationId(itemId, fromLocationId) //아이템 정보와 locationId로 찾는다.
        .orElseThrow(() -> new RuntimeException("Source location not found")); // trhow로

    if (fromInventory.getAvailableQuantity() < quantity) { // 가능한 quantitiy보다 움직이려는 quantitiy가 많으면
      throw new RuntimeException("Insufficient stock at source location");
    }

    setInventoryQuantity(quantity, fromInventory);

    Inventory toInventory = inventoryRepository.findByItemIdAndLocationId(itemId, toLocationId)
        .orElse(new Inventory());

    //itemId,location Id 핸들링
    toInventory.setItem(new Item(itemId));
    toInventory.setLocation(new Location(toLocationId));
    setInventoryQuantity((-quantity), toInventory);
    toInventory.setQuantity(toInventory.getQuantity() + quantity);
    toInventory.setAvailableQuantity(toInventory.getAvailableQuantity() + quantity);

    inventoryRepository.save(fromInventory);
    inventoryRepository.save(toInventory);

    saveInventoryHistory(fromInventory, "MOVE_OUT", -quantity);
    saveInventoryHistory(toInventory, "MOVE_IN", quantity);
  }

  @Transactional
  public void deleteInventory(Long inventoryId) {
    Inventory inventory = inventoryRepository.findById(inventoryId)
        .orElseThrow(() -> new RuntimeException("Inventory not found"));

    saveInventoryHistory(inventory, "DELETE", -inventory.getQuantity());

    inventoryRepository.delete(inventory);
  }

  private void setInventoryQuantity(int quantity, Inventory inventory) {
    inventory.setQuantity(inventory.getQuantity() + quantity);
    inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
  }

  @Transactional
  public Inventory adjustInventory(Long inventoryId, int newQuantity) {
    //재고 고정
    Inventory inventory = inventoryRepository.findById(inventoryId)
        .orElseThrow(
            () -> new ResourceNotFoundException("Inventory not found with id " + inventoryId));
    inventory.setQuantity(newQuantity);
    inventory.setAvailableQuantity(newQuantity - inventory.getAllocatedQuantity());
    return inventoryRepository.save(inventory);


  }
}
