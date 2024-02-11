package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem {

//  정보: 재고 수량, 제품의 위치, 재고 상태(예: 사용 가능, 저재고, 품절), 입출고 기록 등을 포함합니다. 각 InventoryItem은 Product 엔티티를 참조하여 제품 정보와 연결됩니다.
//사용 사례: 재고 관리, 재고 수준 모니터링, 재고 입출고 기록, 재고 위치 추적 등 웨어하우스 운영에 필요한 정보를 제공합니다.

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @OneToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product; //connect to Product

  //warehouse도 연결해야 하나
  private int quantity;

  private String location;

  private LocalDateTime lastUpdated;

  // 필요에 따라 추가적인 필드
  // 예: 재고 상태(정상, 저재고, 품절 등), 입고 예정일, 출하 예정일 등

  // Constructors, Getters, Setters


}
