package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.Item;
import enhanced_inventory.server.repository.WMS.ItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

  private final ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public List<Item> getAllItemsByLIst() {
    return itemRepository.findAll();
  }

}
