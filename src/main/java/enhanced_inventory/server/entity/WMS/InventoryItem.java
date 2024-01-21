package enhanced_inventory.server.entity.WMS;

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
