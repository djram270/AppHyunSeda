/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.client.access.microservice;

import co.unicauca.hyunseda.client.access.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 *
 * @author dizu8
 */
public interface iMicroserviceItem {
    /**
     * Obtiene todos los ítems disponibles.
     *
     * @return Una lista de todos los ítems.
     */
    List<Item> getItems();

    /**
     * Obtiene un ítem específico por su ID.
     *
     * @param strId El ID del ítem a eliminar.
     * @return El ítem correspondiente al ID especificado, o null si no se encontró ningún ítem con ese ID.
     */
    Item getItem(String strId);

    /**
     * Elimina un ítem específico por su ID.
     *
     * @param strId El ID como cadena del item a recuperar.
     * @return Un mensaje indicando si la eliminación fue exitosa o no.
     */
    String deleteItem(String strId);

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
     * @param strId   El ID del ítem a actualizar.
     * @return Un mensaje indicando si la actualización fue exitosa o no.
     */
    String putItem(Item item, String strId);
    
    /**
     * Obtiene un objeto desde un formato JSON
     *
     * @param <T>
     * @param reference
     * @param json El ID de la orden a procesar.
     * @return devuelve el objeto mapeado en caso de exito, null si algo paso
     */
    <T> T getData(String json, TypeReference<T> reference);
}
