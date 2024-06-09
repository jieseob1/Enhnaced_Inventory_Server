package enhanced_inventory.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ToString
@MappedSuperclass //jpa Entity클래스들이 해당 추상 클래스를  상속할 경우, createdDate,modifiedDate를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) //해당 클래스에 Auditing 기능을 포함
public abstract class AuditingFields {
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @CreatedDate
  @Column(nullable = false, updatable = false)
  protected LocalDateTime createdAt; //생성일시

  @CreatedBy
  @Column(nullable = false, updatable = false, length = 100)
  protected String createdBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @LastModifiedDate
  @Column(nullable = false)
  protected LocalDateTime modifiedAt;

  @LastModifiedBy
  @Column(nullable = false, length = 100)
  protected String modifiedBy;
}
