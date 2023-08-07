package enhanced_inventory.server.domain;

import jakarta.persistence.*;

public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "organization")
    private List<User> users;

    // Getters and Setters
}
