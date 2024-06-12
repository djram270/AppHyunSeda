package co.unicauca.microservice.apirest.inputPort;

import co.unicauca.microservice.apirest.model.Category;

import java.util.List;
/**
 * Interfaz para el servicio de categorías.
 *
 * Esta interfaz define los métodos que deben ser implementados por los servicios que manejan las operaciones relacionadas con las categorías.
 */
public interface iCategoryService {

    /**
     * Obtiene todas las categorías.
     *
     * @return La lista de categorías.
     */
    List<Category> getCategories();

    /**
     * Obtiene una categoría por su ID.
     *
     * @param id El ID de la categoría que se desea obtener.
     * @return La categoría correspondiente al ID especificado.
     */
    Category getCategory(Long id);

    /**
     * Obtiene una categoría por su nombre.
     *
     * @param name El nombre de la categoría que se desea obtener.
     * @return La categoría correspondiente al nombre especificado.
     */
    Category getCategoryByName(String name);

    /**
     * Elimina una categoría por su ID.
     *
     * @param id El ID de la categoría que se desea eliminar.
     * @return El mensaje de confirmación de la eliminación.
     */
    String deleteCategory(Long id);

    /**
     * Crea una nueva categoría.
     *
     * @param category La categoría que se va a crear.
     * @return El mensaje de confirmación de la creación.
     */
    String postCategory(Category category);

    /**
     * Actualiza una categoría existente.
     *
     * @param category La categoría actualizada.
     * @param id El ID de la categoría que se desea actualizar.
     * @return El mensaje de confirmación de la actualización.
     */
    String putCategory(Category category, Long id);

    /**
     * Filtra las categorías existentes.
     *
     * @param categories La lista de categorías a filtrar.
     * @return La lista de categorías existentes después del filtrado.
     */
    List<Category> categoriesExisting(List<Category> categories);
}