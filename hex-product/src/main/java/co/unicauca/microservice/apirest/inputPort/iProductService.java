package co.unicauca.microservice.apirest.inputPort;

import co.unicauca.microservice.apirest.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Interfaz para el servicio de productos.
 *
 * Esta interfaz define los métodos que deben ser implementados por los servicios que manejan las operaciones relacionadas con los productos.
 */
public interface iProductService {

    /**
     * Obtiene todos los productos.
     *
     * @return La lista de productos.
     */
    List<Product> getProducts();

    /**
     * Obtiene un producto por su ID.
     *
     * @param id El ID del producto que se desea obtener.
     * @return El producto correspondiente al ID especificado.
     */
    Product getProduct(Long id);

    /**
     * Obtiene productos por su nombre.
     *
     * @param name El nombre del producto que se desea obtener.
     * @return La lista de productos correspondientes al nombre especificado.
     */
    List<Product> getProductByName(String name);

    /**
     * Obtiene productos por su categoría.
     *
     * @param nameCategory El nombre de la categoría de los productos que se desea obtener.
     * @return La lista de productos correspondientes a la categoría especificada.
     */
    List<Product> getProductByCategory(String nameCategory);

    /**
     * Elimina un producto por su ID.
     *
     * @param id El ID del producto que se desea eliminar.
     * @return El mensaje de confirmación de la eliminación.
     */
    String deleteProduct(Long id);

    /**
     * Crea un nuevo producto.
     *
     * @param product El producto que se va a crear.
     * @return El mensaje de confirmación de la creación.
     */
    String postProduct(Product product);

    /**
     * Actualiza un producto existente.
     *
     * @param product El producto actualizado.
     * @param id El ID del producto que se desea actualizar.
     * @return El mensaje de confirmación de la actualización.
     */
    String putProduct(Product product, Long id);
}