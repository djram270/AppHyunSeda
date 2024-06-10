package co.unicauca.microservice.apirest.domain.service.implementation;

import co.unicauca.microservice.apirest.domain.entity.Item;
import co.unicauca.microservice.apirest.domain.service.iItemService;
import co.unicauca.microservice.apirest.repository.iItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements iItemService {
    @Autowired
    private iItemRepository itemRepository;

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }
    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
    @Override
    public String deleteItem(Long id) {
        itemRepository.deleteById(id);
        return "Item was deleted successfully";
    }
    @Override
    public String postItem(Item item) {
        itemRepository.save(item);
        return "Item was created successfully";
    }

    @Override
    public String putItem(Item item, Long id) {
        Item i = itemRepository.findById(id).orElse(null);

        if (i == null)
        {
            return "Item was not updated, an error has occurred";
        }
        item.setItemId(i.getItemId());
        itemRepository.save(item);
        return "Item was updated successfully";
    }
}
