package enhanced_inventory.server.domain.WMS;

import enhanced_inventory.server.domain.AuditingFields;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Item extends AuditingFields {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  private String itemCode;

  @Setter
  private String itemName;

  @Setter
  private String specification;

  @Setter
  @Column(length = 50)
  private String unit;

  @Setter
  private String category;

  @Setter
  private String barcode;

  @Setter
  private String image;

  @Setter
  private Long price;

  @Setter
  private int stockAlertLevel;

//  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//  private List<Inventory> inventories; //하나의 item, 여러 inventory 가질 수 있음
}
