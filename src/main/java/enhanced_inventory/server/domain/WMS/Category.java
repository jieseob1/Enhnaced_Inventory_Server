package enhanced_inventory.server.domain.WMS;

import java.time.LocalTime;

public class Category {
//  기본 정보
//  CategoryId: 카테고리의 고유 식별자 (일반적으로 Primary Key)
//  CategoryName: 카테고리 이름
//  Description: 카테고리에 대한 설명 혹은 요약
//  ParentCategoryId: 상위 카테고리의 ID (계층적인 카테고리 구조를 가질 경우)
//  메타데이터
//  CreatedAt: 카테고리가 생성된 날짜와 시간
//  UpdatedAt: 카테고리 정보가 마지막으로 업데이트된 날짜와 시간
//  CreatedBy: 카테고리를 생성한 사용자나 시스템
//  UpdatedBy: 카테고리를 마지막으로 업데이트한 사용자나 시스템
//  추가 정보
//  IsActive: 카테고리가 현재 활성 상태인지 여부 (예: true/false)
//  SortOrder: 카테고리의 정렬 순서 (UI 표시에 사용될 수 있음)
//  Icon: 카테고리 아이콘의 URL 또는 파일 경로
//  Keywords: 검색 엔진 최적화 (SEO)나 검색에 사용할 수 있는 키워드
//  Visibility: 카테고리의 가시성 설정 (예: 전체 공개, 회원 전용 등)
//  연관 데이터
//  ProductCount: 해당 카테고리에 속한 상품의 수 (Denormalized field로 유지될 수 있음)
//  ChildCategories: 하위 카테고리 목록 (계층적 카테고리 구조를 사용할 경우)
  private String id;
  private String name;
  private String description;
  private String parentCategoryId;

  //meta
  private LocalTime createdAt;
  private LocalTime updatedAt;

  private String createdBy;
  private String updatedBy;
  //Additional
  private boolean isActive;


}
