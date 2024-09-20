package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.Location;
import enhanced_inventory.server.repository.WMS.LocationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

  private final LocationRepository locationRepository;

  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public List<Location> getAllLocationsByList() {
    return locationRepository.findAll();
  }
}
