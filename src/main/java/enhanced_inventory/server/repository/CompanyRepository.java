package enhanced_inventory.server.repository;

import enhanced_inventory.server.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
