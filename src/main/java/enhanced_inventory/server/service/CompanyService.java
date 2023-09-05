package enhanced_inventory.server.service;

import enhanced_inventory.server.domain.Company;
import enhanced_inventory.server.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompanyService {
  @Autowired
  private CompanyRepository companyRepository;

  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  public Company getCompanyById(String id) {
    return companyRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Company not found"));
  }

  @Transactional
  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }

  @Transactional
  public Company updateCompany(String id, Company company) {
    Company existingCompany = getCompanyById(id);
    // 여기서 existingCompany의 각 필드를 업데이트 해준다.
    return companyRepository.save(existingCompany);
  }

  public void deleteCompany(String id) {
    companyRepository.deleteById(id);
  }
}