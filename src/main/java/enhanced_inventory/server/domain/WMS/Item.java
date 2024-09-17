package enhanced_inventory.server.domain.WMS;

import enhanced_inventory.server.domain.AuditingFields;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "item")
public class Item extends AuditingFields {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "item_code", nullable = false, length = 255)
  private String itemCode;

  @Column(name = "item_name", nullable = false, length = 255)
  private String itemName;

  @Column(length = 255)
  private String specification;

  @Column(length = 50)
  private String unit;

  @Column(length = 255)
  private String category;

  @Column(length = 255)
  private String barcode;

  @Column(length = 255)
  private String image;

  @Column(precision = 10, scale = 2)
  private BigDecimal price;

  @Column(name = "stock_alert_level")
  private Integer stockAlertLevel;

  @OneToMany(mappedBy = "item")
  private List<PurchaseOrderItem> purchaseOrderItems;

  @OneToMany(mappedBy = "item")
  private List<ReceiptItem> receiptItems;

  @OneToMany(mappedBy = "item")
  private List<Inventory> inventories;
}
