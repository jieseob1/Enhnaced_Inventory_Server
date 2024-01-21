package enhanced_inventory.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

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
public class User {
    @Id
    @Column(length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 별도로 ID를 관리할 필요가 없어짐
    private String id;

    @Setter
    @Column(nullable = false) private String userPassword;

    @Setter @Column(length = 100) private String email;
    @Setter @Column(length = 100) private String role;
    //companyId, @ManytoOne이 붙은 Company company 필드 둘다 companyId컬럼에 매핑
    //@Column(insertable= false, updatable=false) 어노테이션 사용, 하나의 필드만 실제로 DB에 쓰게 만들자
    @Column(name="companyId", insertable = false, updatable = false)
    private String companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    @Setter private String memo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt; // 생성일시

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 100)
    protected String createdBy; // 생성자
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime modifiedAt; // 수정일시

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    protected String modifiedBy; // 수정자


    private User(String id, String userPassword, String email, String role, String memo,String companyId, String createdBy) {
        this.id = id;
        this.userPassword = userPassword;
        this.email = email;
        this.role = role;
        this.memo = memo;
        this.companyId = companyId;
        this.createdBy = createdBy;
    }

    public static User of(String id, String userPassword, String email, String role, String memo,String companyId) {
        return User.of(id, userPassword, email, role, memo, companyId,id);
    }

    public static User of(String id, String userPassword, String email, String role, String memo,String companyId, String createdBy) {
        return new User(id, userPassword, email, role, memo,companyId, createdBy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}
