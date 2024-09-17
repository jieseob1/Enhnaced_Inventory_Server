package enhanced_inventory.server.domain.WMS;

import enhanced_inventory.server.domain.AuditingFields;
import enhanced_inventory.server.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Role extends AuditingFields {
    /**
     * 권한 관리: 권한 생성, 수정, 삭제.
     * 권한 정보 조회: 특정 권한에 대한 상세 정보 조회.
     * 권한 할당: 사용자에게 특정 권한을 할당하거나 해제.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String roleName; //어케 해야되지?
    @Setter
    private String description;

    @ManyToMany(mappedBy = "roles") //앞어 정의해놓은 set인 rolese
    private Set<User> users = new HashSet<>(); //user는 role에 매핑된다.


}
