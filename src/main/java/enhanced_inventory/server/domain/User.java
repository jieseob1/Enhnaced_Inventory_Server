package enhanced_inventory.server.domain;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;

    @ManyToOne
    private Orgaiz

}
