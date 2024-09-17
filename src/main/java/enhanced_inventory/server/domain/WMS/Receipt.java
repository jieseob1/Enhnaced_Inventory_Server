package enhanced_inventory.server.domain.WMS;

import enhanced_inventory.server.domain.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    // 입고관련 기능
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private LocalDateTime receiptDate; // 실제 입고가 발생한 날짜

    @Setter
    @Column(length = 50)
    private  String size; // 입고 할때 사이즈?

    @Setter
    @Column(length = 50)
    private String temperatrueCondition;

    @Setter
    @Column(length = 50)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expect_receipt_id", nullable = false)
    private ExpectedReceipt expectedReceipt; // 예상 입고와 연관된 식별자

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReceiptItem> receiptItems; // receiptItem에 있는 receipt 필드 이름이 mappedby

}
