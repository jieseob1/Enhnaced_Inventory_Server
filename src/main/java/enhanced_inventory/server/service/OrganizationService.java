package enhanced_inventory.server.service;

import enhanced_inventory.server.domain.Organization;
import enhanced_inventory.server.repository.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

  @Autowired
  private OrganizationRepository organizationRepository;

  public List<Organization> getAllOrganizations() {
    return organizationRepository.findAll();
  }

  public Organization getOrganizationById(String id) {
    return organizationRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Organization not found"));
  }

  @Transactional
  public Organization createOrganization(Organization organization) {
    return organizationRepository.save(organization);
  }

  @Transactional
  public Organization updateOrganization(String id, Organization organization) {
    Organization existingOrganization = getOrganizationById(id);
    // 여기서 existingOrganization의 각 필드를 업데이트 해준다.
    return organizationRepository.save(existingOrganization);
  }

  public void deleteOrganization(String id) {
    organizationRepository.deleteById(id);
  }
}
