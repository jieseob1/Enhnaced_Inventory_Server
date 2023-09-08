package enhanced_inventory.server.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

@ToString
@Entity
public class Logistics {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String shipmentStatus;
  private String originCountryId;
  private String destinationCountryId;
  private String companyId;
}
