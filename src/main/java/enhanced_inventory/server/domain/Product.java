package enhanced_inventory.server.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
  @Id
  private Long id;
  private String name;
  private int price;
}
