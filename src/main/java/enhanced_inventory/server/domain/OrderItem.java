package enhanced_inventory.server.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
  @Id
  private Long id;
  private int quantity;
  @ManyToOne
  private Product product;
}
