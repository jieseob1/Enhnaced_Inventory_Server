package enhanced_inventory.server.controller;

import enhanced_inventory.server.domain.Company;
import enhanced_inventory.server.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CompanyController {
  @Autowired
  private CompanyService companyService;

  @GetMapping("/")
  public List<Company> getAllCompanies() {
    return companyService.getAllCompanies();
  }

  @GetMapping("/{id}")
  public Company getCompanyById(@PathVariable String id) {
    return companyService.getCompanyById(id);
  }

  @PostMapping("/")
  public Company createCompany(@RequestBody Company company) {
    return companyService.createCompany(company);
  }

  @PutMapping("/{id}")
  public Company updateCompany(@PathVariable String id, @RequestBody Company company) {
    return companyService.updateCompany(id, company);
  }

  @DeleteMapping("/{id}")
  public void deleteCompany(@PathVariable String id) {
    companyService.deleteCompany(id);
  }
}
