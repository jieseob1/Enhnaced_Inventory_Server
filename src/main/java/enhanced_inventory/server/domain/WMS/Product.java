package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Product {
//    ProductID: 상품의 고유 식별자
//    ProductName: 상품 이름
//    Category: 상품 카테고리
//    Price: 상품 가격
//    Manufacturer: 제조사
//    StockQuantity: 재고 수량
//    SKU: Stock Keeping Unit, 재고 유지 단위
//    Barcode: 바코드 번호
//    Weight: 상품의 무게
//    Dimensions: 상품의 크기 (길이, 너비, 높이)
//    Color: 색상
//    Material: 소재
//    MinimumStockLevel: 최소 재고 수준
//    MaximumStockLevel: 최대 재고 수준
//    LeadTime: 리드 타임 (공급처에서 상품을 받을 때까지의 시간)
//    ProductVersion: 상품 버전 (소프트웨어나 업데이트 가능한 제품의 경우)
//  SerialNumberRange: 시리얼 번호 범위
//  WarrantyPeriod: 보증 기간
//  지리적 정보
//  OriginCountry: 원산지
//  ImportDuties: 수입 관세 정보
//  재고
//  ReservedStock: 예약된 재고 (예: 온라인 주문)
//  DamagedStock: 손상된 재고
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private int status; // check
  private String type;
  private String Vendor;
  private String productImage;
  private BigDecimal price;
  // image and plus
}
