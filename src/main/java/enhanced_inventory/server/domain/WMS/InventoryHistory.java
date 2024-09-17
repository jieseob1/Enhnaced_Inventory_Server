package enhanced_inventory.server.domain.WMS;

import enhanced_inventory.server.domain.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "InventoryHistory")
public class InventoryHistory extends AuditingFields {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inventory_id", nullable = false)
  private Inventory inventory;
  //modified로 알아볼 예정

  @Setter
  @Column(length = 5000)
  private String exchangeReason;

  @Setter
  private int exchangeQuantity;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Setter
  @Column(nullable = false)
  private LocalDateTime exchangeDate;

  @Setter
  private int status;
}
