package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Return {
  //환불

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "shipment_id")
  private Shipment shipment;

  @Setter
  @Column(length = 1000)
  private String returnReason;

  @Setter
  private int returnQuantity;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Setter
  @Column(nullable = false)
  private LocalDateTime returnDate;

  @Setter
  private int status;
}
