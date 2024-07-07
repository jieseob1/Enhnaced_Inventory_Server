package enhanced_inventory.server.domain.WMS;

import enhanced_inventory.server.domain.AuditingFields;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Inventory extends AuditingFields {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  private int quantity;

  @Setter
  private int allocatedQuantity; // 여기서 할당된 quantitiy는 뭔가

  @Setter
  private int availableQuantity;

  @Setter
  private LocalDateTime receiptDate;

  @Setter
  @Column(length = 50)
  private String status;

  //    Item
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "itemId", nullable = false)
//  private Item item; //mappedBy가 item인거
  //    Location
  @ManyToOne
  @JoinColumn(name = "locationId", nullable = false)
  private Location location;

}
