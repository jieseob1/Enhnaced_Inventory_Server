package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
//  WarehouseID: 창고의 고유 식별자
//  Location: 창고 위치
//  Capacity: 창고 용량
//  Aisle: 창고 안의 통로 정보
//  Shelf: 창고의 선반 정보
//  TemperatureZone: 온도 구역 (냉장, 냉동, 상온 등)
//  SecurityLevel: 보안 수준
//  OperatingHours: 운영 시간
//
//  공간 구성
//  FloorMaterial: 바닥재료 (예: 콘크리트, 나무)
//  WallMaterial: 벽재료
//  CeilingHeight: 천장 높이
//  특수 구역
//  QuarantineZone: 격리 구역 (예: 손상된 물품, 리콜된 물품)
//  PickAndPackZone: 피킹 및 패킹 구역
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String location;
  private String capacity;
  private String temperatureZone; //실온,상온, 냉동 => 추후 enum
  private String securityLevel;
  private String operationHours;

}
