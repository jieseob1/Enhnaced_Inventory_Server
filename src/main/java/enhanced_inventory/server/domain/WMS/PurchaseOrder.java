package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private LocalDate orderDate;
    private LocalDate dueDate;
    private String status;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    private List<PurchaseOrderItem> items;
    // 1개의 구매 주문에는 여러개의 purchaseorderItem이 있을 수 있다.
    //mappedBy 속성 사용 예시:
    // Purchsaeorder 엔티티의 items 필드는 PurchaeorderItem 엔티티의 purchaseOrder 필드에 의해 매핑됩니다.
    // 이는 PurchaeorderItem 엔티티가 관계의 주인임을 의미합니다.

    @ManyToOne
    @JoinColumn(name = "supplier_id") // fk로  사용되는 듯 //supplier가 purchaseOrder 참조
    private Supplier supplier;// 자식 테이블이 부모 테이블 참조중
}
