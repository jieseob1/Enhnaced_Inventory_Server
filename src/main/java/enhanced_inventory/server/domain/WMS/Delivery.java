package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "Delivery")
public class Delivery {
  //배송 자체에 대한 정보를 관리
  // 이는 배송 과정의 각 단계(예: 준비, 출하, 배송 중, 배송 완료)와 관련된 전반적인 정보를 포함
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "shipment_id", nullable = false)
  private Shipment shipment;

  @Setter
  private String deliveryCompany; //이거 회사랑 연결시켜야 할 수도

  @Setter
  private String trackingNumber;

  @Setter
  private int status; //배송 상태

  @Setter
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(nullable = false)
  private LocalDateTime deliveryStartDate;

  @Setter
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(nullable = false)
  private LocalDateTime deliveryEndDate;
}
