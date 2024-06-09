package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryProduct {
  //배송 과정에서 개별 제품들에 관한 상세 정보를 관리
  // 배송에 포함된 개별 제품 => Delivery와 다대다 관계
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

//  DeliveryProductID: 배송 상품의 고유 식별자
//DeliveryID: 연관된 배송의 식별자
//ProductID: 제품의 식별자
//Quantity: 해당 배송에 포함된 제품의 수량
//  ProductStatus: 제품의 배송 상태를 나타내는 필드입니다.
//  예를 들어, '포장 완료', '출하 대기', '배송 중' 등의 상태를 관리할 수 있습니다.
//      ProductWeight: 개별 제품의 무게입니다. 이 정보는 배송 비용 계산이나 물류 계획 수립에 유용할 수 있습니다.
//      Dimensions: 제품의 치수(길이, 너비, 높이) 정보입니다. 배송 컨테이너의 공간 배치 최적화에 도움이 될 수 있습니다.
//      PackingType: 제품의 포장 타입 정보입니다. 예를 들어, '박스 포장', '비닐 포장' 등의 정보를 담을 수 있습니다.
//      HandlingInstructions: 제품의 취급 주의사항입니다. 예를 들어, '충격 주의', '상하 조심', '습기 방지' 등의 지침을 포함할 수 있습니다.
//      SerialNumber: 제품의 시리얼 번호입니다. 제품 추적과 관리에 중요한 역할을 할 수 있습니다.
//  ManufacturedDate: 제품의 제조 날짜입니다. 제품의 신선도나 유통기한 관리에 사용될 수 있습니다.
//      ExpiryDate: 제품의 유통기한입니다. 특히 식품이나 의약품 배송에 중요한 정보입니다.
}
