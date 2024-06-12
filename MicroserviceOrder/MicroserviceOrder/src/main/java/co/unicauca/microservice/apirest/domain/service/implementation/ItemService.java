package co.unicauca.microservice.apirest.domain.service.implementation;

import co.unicauca.microservice.apirest.domain.entity.Item;
import co.unicauca.microservice.apirest.domain.service.iItemService;
import co.unicauca.microservice.apirest.repository.iItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Un servicio para realizar operaciones CRUD en los ítems de la orden.
 */
@Service
@RequiredArgsConstructor
public class ItemService implements iItemService {
    /**
     * El repositorio utilizado para acceder a los datos de los ítems.
     */
    @Autowired
    private iItemRepository itemRepository;

    /**
     * Recupera todos los ítems.
     *
     * @return Una lista de todos los ítems.
     */
    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    /**
     * Recupera un ítem por su identificador.
     *
     * @param id El identificador del ítem a recuperar.
     * @return El ítem recuperado, o null si no se encuentra.
     */
    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un ítem por su identificador.
     *
     * @param id El identificador del ítem a eliminar.
     * @return Un mensaje indicando el resultado de la operación de eliminación.
     */
    @Override
    public String deleteItem(Long id) {
        itemRepository.deleteById(id);
        return "Item was deleted successfully";
    }

    /**
     * Crea un nuevo ítem.
     *
     * @param item El ítem a crear.
     * @return Un mensaje indicando el resultado de la operación de creación.
     */
    @Override
    public String postItem(Item item) {
        itemRepository.save(item);
        return "Item was created successfully";
    }

    /**
     * Actualiza un ítem existente.
     *
     * @param item El ítem actualizado.
     * @param id   El identificador del ítem a actualizar.
     * @return Un mensaje indicando el resultado de la operación de actualización.
     */
    @Override
    public String putItem(Item item, Long id) {
        Item i = itemRepository.findById(id).orElse(null);

        if (i == null) {
            return "Item was not updated, an error has occurred";
        }
        item.setItemId(i.getItemId());
        itemRepository.save(item);
        return "Item was updated successfully";
    }
}
