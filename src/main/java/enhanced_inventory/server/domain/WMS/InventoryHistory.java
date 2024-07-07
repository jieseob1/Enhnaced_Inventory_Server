package enhanced_inventory.server.domain.WMS;

import enhanced_inventory.server.domain.AuditingFields;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InventoryHistory extends AuditingFields {

  // 재고 이력을 관리하는 클래스
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //1개의 inventoryid에 대해 여러개의 이력이 존재할 수 있음
  @ManyToOne
  @JoinColumn(name = "inventoryId", nullable = false)
  private Inventory inventory; //하나의 재고에 대해 여러개의 이력이 존재할 수 있음


  @Column(length = 50)
  private String changeType; // 변경 타입

  private int changeQuantity; // 변경된 수량
}
