package enhanced_inventory.server.controller.WMS;

import enhanced_inventory.server.domain.WMS.Location;
import enhanced_inventory.server.service.WMS.LocationService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {

  private LocationService locationService;

  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  public ResponseEntity<List<Location>> getAllLocations() {
    List<Location> locations = locationService.getAllLocationsByList();
    return ResponseEntity.ok(locations);
  }
}
