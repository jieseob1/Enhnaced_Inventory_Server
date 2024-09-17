package enhanced_inventory.server.domain.WMS;

import enhanced_inventory.server.domain.AuditingFields;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Location extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String locationCode;

    @Setter
    private String locationType;

    @Setter
    private String description;

    @Setter
    private String size;

    @Setter
    private String tempatureCondition;

    @Setter
    private String status;

    @OneToMany(mappedBy = "location", orphanRemoval = true, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Inventory> inventories;
}
