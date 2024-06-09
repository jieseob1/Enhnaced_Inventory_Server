package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PurchaseOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productCode;
    private int quantity;
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder; //해당 필드가 관계의 주인 => 즉, 외래키 관리자
}
