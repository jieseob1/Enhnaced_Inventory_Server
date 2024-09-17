package enhanced_inventory.server.domain.WMS;

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
@Table(name = "Shipment")
public class Shipment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shipping_order_id", nullable = false)
  private ShippingOrder shippingOrder;

  @Setter
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(nullable = false)
  private LocalDateTime shipmentDate;


  @Setter
  private int status; // 추후 enum으로 변경
}
