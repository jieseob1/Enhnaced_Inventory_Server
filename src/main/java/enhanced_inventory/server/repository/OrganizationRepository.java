package enhanced_inventory.server.repository;

import enhanced_inventory.server.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, String> {}

