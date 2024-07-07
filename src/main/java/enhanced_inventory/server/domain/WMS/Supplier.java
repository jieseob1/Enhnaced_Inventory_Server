package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  private String supplierName;

  @Setter
  private String contactInfo;

  @Setter
  private String address;

  @Setter
  private String supplierType;

  //orphanRemoval: 부모 엔티티에서 자식 엔티티 제거될 떄, 자식 엔티티에서 데이터베이스가 삭제
  @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PurchaseOrder> purchaseOrders;
}
