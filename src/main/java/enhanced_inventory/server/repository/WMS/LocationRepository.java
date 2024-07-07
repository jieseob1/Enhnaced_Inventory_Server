package enhanced_inventory.server.repository.WMS;

import enhanced_inventory.server.domain.WMS.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    //Location findLocationById(Long id);
    //Location findLocationByLocationCode(String locationCode);
    //Location findLocationByLocationType(String locationType);
    //Location findLocationByDescription(String description);
    //Location findLocationBySize(String size);
    //Location findLocationByTempatureCondition(String tempatureCondition);
    //Location findLocationByStatus(String status);
    //Location findLocationByLocationCodeAndLocationType(String locationCode, String locationType);
    //Location findLocationByLocationCodeAndDescription(String locationCode, String description);
    //Location findLocationByLocationCodeAndSize(String locationCode, String size);
    //Location findLocationByLocationCodeAndTempatureCondition(String locationCode, String tempatureCondition);
    //Location findLocationByLocationCodeAndStatus(String locationCode, String status);
    //Location findLocationByLocationTypeAndDescription(String locationType, String description);
    //Location findLocationByLocationTypeAndSize(String locationType, String size);
    //Location findLocationByLocationTypeAndTempatureCondition(String locationType, String tempatureCondition);
    //Location findLocationByLocationTypeAndStatus(String locationType, String status);
    //Location findLocationByDescriptionAndSize(String description, String size);
}
