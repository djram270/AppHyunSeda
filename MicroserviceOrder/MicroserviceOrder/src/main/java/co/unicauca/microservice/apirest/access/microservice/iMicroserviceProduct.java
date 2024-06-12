package co.unicauca.microservice.apirest.access.microservice;

import co.unicauca.microservice.apirest.access.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 * Interfaz para el cliente de microservicios relacionados con productos.
 *
 * Esta interfaz define los métodos para interactuar con un servicio de microservicios que maneja productos.
 */
public interface iMicroserviceProduct {

    /**
     * Obtiene la lista de productos.
     *
     * @return La lista de productos.
     */
    List<Product> getProducts();

    /**
     * Obtiene un producto por su identificador.
     *
     * @param strId El identificador del producto.
     * @return El producto correspondiente al identificador especificado.
     */
    Product getProduct(String strId);

    /**
     * Publica un producto.
     *
     * @param p El producto que se desea publicar.
     * @return Un mensaje de confirmación sobre la publicación del producto.
     */
    String postProduct(Product p);

    /**
     * Elimina un producto por su identificador.
     *
     * @param strId El identificador del producto que se desea eliminar.
     * @return Un mensaje de confirmación sobre la eliminación del producto.
     */
    String deleteProduct(String strId);

    /**
     * Actualiza un producto.
     *
     * @param p El producto actualizado.
     * @param strId El identificador del producto que se desea actualizar.
     * @return Un mensaje de confirmación sobre la actualización del producto.
     */
    String putProduct(Product p, String strId);

    /**
     * Obtiene datos de un servicio externo a partir de un JSON.
     *
     * @param json El JSON que contiene los datos.
     * @param reference La referencia al tipo de datos esperado.
     * @param <T> El tipo de datos esperado.
     * @return Los datos obtenidos del servicio externo.
     */
    <T> T getData(String json, TypeReference<T> reference);
}