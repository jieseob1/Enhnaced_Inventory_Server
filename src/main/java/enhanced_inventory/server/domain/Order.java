package enhanced_inventory.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Setter private Customer customer;

    @OneToMany
    @Setter  private List<Product> products; //productLIst

    //기타 필요한 빌드
    // 생성자 getter/setter  기타 메소드등


}
