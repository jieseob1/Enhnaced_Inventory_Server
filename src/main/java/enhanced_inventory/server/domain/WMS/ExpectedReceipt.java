package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class ExpectedReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate expectedDate;
    private int expectedQuantity;
    private String status;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @OneToMany(mappedBy = "expectedReceipt")
    private List<Receipt> receipts;

    // Getters and setters
}