package enhanced_inventory.server.entity.WMS;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.ToString;

import java.util.List;

@Entity
@ToString(callSuper = true)
public class Order {
  @Id
  private Long id;
  private String status; // 주문 상태

  @OneToMany
  List<OrderItem> orderItems;
}
