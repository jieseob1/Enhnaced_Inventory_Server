package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    //구매 오더 등록 관련
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private String orderNumber;
    private LocalDate orderDate;
    private String status;

    //purchaseorder 엔티티에서 Order 엔티티로 모든 작업이 전파된다.
    //mappedby: 양방향 관계에서 관계의 주인(owner)정의 => mappedBy는 반대쪽 엔티티에서 관계를 소유하고 있는 필드 지정

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    private List<PurchaseOrderItem> items;
    // 1개의 구매 주문에는 여러개의 purchaseorderItem이 있을 수 있다.
    //mappedBy 속성 사용 예시:
    // Purchsaeorder 엔티티의 items 필드는 PurchaeorderItem 엔티티의 purchaseOrder 필드에 의해 매핑됩니다.
    // 이는 PurchaeorderItem 엔티티가 관계의 주인임을 의미합니다.

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

}
