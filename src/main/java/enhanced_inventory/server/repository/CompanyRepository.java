package enhanced_inventory.server.repository;

import enhanced_inventory.server.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}