package co.unicauca.microservice.apirest.domain.service;

import java.util.List;

import co.unicauca.microservice.apirest.domain.entity.Item;

public interface iItemService {
    /**
     * Obtiene todos los ítems disponibles.
     *
     * @return Una lista de todos los ítems.
     */
    List<Item> getItems();

    /**
     * Obtiene un ítem específico por su ID.
     *
     * @param id El ID del ítem a recuperar.
     * @return El ítem correspondiente al ID especificado, o null si no se encontró ningún ítem con ese ID.
     */
    Item getItem(Long id);

    /**
     * Elimina un ítem específico por su ID.
     *
     * @param id El ID del ítem a eliminar.
     * @return Un mensaje indicando si la eliminación fue exitosa o no.
     */
    String deleteItem(Long id);

    /**
     * Crea un nuevo ítem.
     *
     * @param item El ítem a crear.
     * @return Un mensaje indicando si la creación fue exitosa o no.
     */
    String postItem(Item item);

    /**
     * Actualiza un ítem existente por su ID.
     *
     * @param item El nuevo información del ítem.
     * @param id   El ID del ítem a actualizar.
     * @return Un mensaje indicando si la actualización fue exitosa o no.
     */
    String putItem(Item item, Long id);
}
