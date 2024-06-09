package enhanced_inventory.server.domain;

import enhanced_inventory.server.domain.WMS.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
    @Index(columnList = "email", unique = true),
    @Index(columnList = "createdAt"),
    @Index(columnList = "createdBy")
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends AuditingFields {
  /**
   * 회원 일련번호
   * 	- 아이디
   * 	- 이름
   * 	- 비밀번호
   * 	- 권한: 일반, 중간 관리자 ,마스터
   *    - 회사
   * 	- 연락처: 사용자의 전화번호 또는 내선번호
   * 	- 부서: 사용자가 속한 부서 정보
   * 	- 직책: 사용자의 직책 또는 직급
   * 	- 상태: 사용자 계정의 활성화 여부 (활성, 비활성, 잠금 등)
   *
   *
   * 사용자 인증 및 인가: 사용자의 로그인, 로그아웃, 권한 확인.
   * 사용자 관리: 사용자 생성, 수정, 삭제.
   * 사용자 정보 조회: 사용자의 프로필 정보 조회.
   * 사용자 상태 관리: 사용자 계정의 활성화/비활성화, 계정 잠금 등.
   */
  @Id
  @Column(length = 50)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // 별도로 ID를 관리할 필요가 없어짐
  private String id;


  @Setter
  @Column(length = 100)
  private String email;


  @Setter
  @Column(nullable = false)
  private String userPassword;

  @Setter
  @Column(nullable = false)
  private String userName;

  @Setter
  private String contactInfo;

  @Setter
  @Column(nullable = false)
  private String userId;

  @Setter
  @Column(length = 100)
  private String role;

  @Setter
  private String userActive; //enum 값 넣기
  //companyId, @ManytoOne이 붙은 Company company 필드 둘다 companyId컬럼에 매핑
  //@Column(insertable= false, updatable=false) 어노테이션 사용, 하나의 필드만 실제로 DB에 쓰게 만들자
  @Column(name = "companyId", insertable = false, updatable = false)
  private String companyId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyId")
  private Company company;

  @Setter
  private String memo;

  @ManyToMany
  @JoinTable(
          name = "user_role",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles = new HashSet<>(); //이건 언제 쓰는거지


  private User(String id, String userPassword, String email, String role, String memo, String companyId, String createdBy) {
    this.id = id;
    this.userPassword = userPassword;
    this.email = email;
    this.role = role;
    this.memo = memo;
    this.companyId = companyId;
    this.createdBy = createdBy;
  }

  public static User of(String id, String userPassword, String email, String role, String memo, String companyId) {
    return User.of(id, userPassword, email, role, memo, companyId, id);
  }

  public static User of(String id, String userPassword, String email, String role, String memo, String companyId, String createdBy) {
    return new User(id, userPassword, email, role, memo, companyId, createdBy);
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (!(o instanceof User that)) {
          return false;
      }
    return this.getId() != null && this.getId().equals(that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getId());
  }

}
