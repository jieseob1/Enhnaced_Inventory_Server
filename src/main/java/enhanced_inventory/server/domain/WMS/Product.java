package enhanced_inventory.server.domain.WMS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  //    ProductID: 상품의 고유 식별자
//    ProductName: 상품 이름
//    Category: 상품 카테고리
//    Price: 상품 가격
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
//    Manufacturer: 제조사
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String productImage;
  private String name;
  private String description;
  private BigDecimal price;
  private String status; // check
  private String type;
  private String SKU;
  private int stockQuantity;
  private String barcode;
  private String weight;
  private String color;
  private String material;
  private String Vendor;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "product_categories", // 조인 테이블 이름
      joinColumns = @JoinColumn(name = "product_id"), // 현재 엔티티를 참조하는 FK
      inverseJoinColumns = @JoinColumn(name = "category_id") // 반대 엔티티를 참조하는 FK
  )
  private Set<Category> categories = new HashSet<Category>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @CreatedDate
  @Column(nullable = false, updatable = false)
  protected LocalDateTime createdAt;

  @CreatedBy
  @Column(nullable = false, updatable = false, length = 100)
  protected String createdBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @LastModifiedDate
  @Column(nullable = false)
  protected LocalDateTime modifiedAt; // 수정일시

  @LastModifiedBy
  @Column(nullable = false, length = 100)
  protected String modifiedBy; // 수정자

  // image and plus
}
