package enhanced_inventory.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(callSuper = true)
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This part
    private String id;

    private String name;
    private String address;
    private String industryType;
    private String contactInformation;
    private String organizationId;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL) // cascade쪽은 뭐지
    private List<User> users = new ArrayList<>();
}
