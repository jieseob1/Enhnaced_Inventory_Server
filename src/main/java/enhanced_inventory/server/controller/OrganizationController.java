package enhanced_inventory.server.controller;

import enhanced_inventory.server.entity.Organization;
import enhanced_inventory.server.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

  @Autowired
  private OrganizationService organizationService;

  @GetMapping("/")
  public List<Organization> getAllOrganizations() {
    return organizationService.getAllOrganizations();
  }

  @GetMapping("/{id}")
  public Organization getOrganizationById(@PathVariable String id) {
    return organizationService.getOrganizationById(id);
  }

  @PostMapping("/")
  public Organization createOrganization(@RequestBody Organization organization) {
    return organizationService.createOrganization(organization);
  }

  @PutMapping("/{id}")
  public Organization updateOrganization(@PathVariable String id, @RequestBody Organization organization) {
    return organizationService.updateOrganization(id, organization);
  }

  @DeleteMapping("/{id}")
  public void deleteOrganization(@PathVariable String id) {
    organizationService.deleteOrganization(id);
  }
}
