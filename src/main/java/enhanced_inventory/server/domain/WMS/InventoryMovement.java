package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InventoryMovement {
  //입출고 => 좀 더 고민 필요 입출고 됐을 때 어떤 플로우로 갈지

//  TransactionID: 거래의 고유 식별자
//  ProductID: 관련 상품 ID
//  WarehouseID: 관련 창고 ID => 위의 부분들은 모두 다 연결되는 부분
//  Quantity: 입/출고 수량
//  TransactionType: 거래 유형 (입고, 출고)
//  TransactionDate: 거래 일자
//
//  OperatorID: 작업자 ID
//  Method: 입/출고 방법 (수동, 자동)
//  Source: 입고의 경우 공급처, 출고의 경우 목적지
//  Cost: 입/출고 비용
//  BatchNumber: 배치 번호 (유통기한 등을 트래킹할 때 사용
//      InvoiceNumber: 송장 번호
//      PackingSlip: 포장 목록
//      QualityCheckMethod: 품질 검사 방법
//      RMA: Return Merchandise Authorization, 반품 승인 번호
  private String id;

}
