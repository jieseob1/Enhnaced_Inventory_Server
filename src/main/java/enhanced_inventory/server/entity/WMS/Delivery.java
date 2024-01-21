package enhanced_inventory.server.entity.WMS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
  //배송 자체에 대한 정보를 관리
  // 이는 배송 과정의 각 단계(예: 준비, 출하, 배송 중, 배송 완료)와 관련된 전반적인 정보를 포함
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long deliveryId;
  private Long departureWarehouseId;
  private String destination;

  private String estimatedArrivalTime;
  private String arrivalStatus; // 이넘으로 변경
  private String carrier; //운송 업체
  private String trackingNumber; //추적 번호
  private String shippingCost; // 배송 비용
  private String deliveryMethod; // 배송 방법(택배, 화물, 항공)

  private String currentLocation; //현재 위치
  private Time lastUpatedTime;

//  EstimatedDeliveryWindow: 예상 배송 시간대
//  SignatureRequired: 서명 필요 여부
//  InsuranceDetails: 보험 상세 정보

}
