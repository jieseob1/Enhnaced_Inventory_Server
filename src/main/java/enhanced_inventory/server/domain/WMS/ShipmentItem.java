package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "ShipmentItem")
public class ShipmentItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "shipment_id", nullable = false)
  private Shipment shipment;

  @ManyToOne
  @JoinColumn(name = "item_id", nullable = false)
  private Item item;

  @Setter
  private int quantity;

  @Setter
  private String lotNumber;

  @Setter
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(nullable = false)
  private LocalDateTime expirationDate;

}
