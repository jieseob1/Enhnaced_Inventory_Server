package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiptid", nullable = false)
    private Receipt receipt;

    @Setter
    @JoinColumn(name = "itemid", nullable = false)
    private Item item;

    @Setter
    private int quantity;

    @Setter
    @Column(length = 255)
    private String lotNumber;

    @Setter
    private LocalDateTime expirationDate;
}
