package co.unicauca.hyunseda.client.access.microservice;

/**
 *
 * @author dizu8
 */

import co.unicauca.hyunseda.client.access.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public interface iMicroserviceProduct {
    /**
     * Obtiene todas los productos disponibles.
     *
     * @return Una lista de todas los productos.
     */
    List<Product> getProducts ();
    
    /**
     * Obtiene un  producto específicado por su ID.
     *
     * @param strId El ID como cadena del producto a recuperar.
     * @return El producto correspondiente al ID especificado, o null si no se encontró ningún producto con ese ID.
     */
    Product getProduct (String strId);
    
    /**
     * Obtiene todos los productos disponibles con el nombre de producto.
     *
     * @param name El nombre de los productos que se desea buscar.
     * @return Lista con los productos encontrados.
     */
    List<Product> getProductName (String name);
    
    /** 
     * Obtiene todos los productos disponibles con la categoria de producto.
     *
     * @param nameCategory La categoria por la que se desean filtrar los productos.
     * @return Un mensaje indicando si la eliminación fue exitosa o no.
     */
    List<Product> getProductCategory (String nameCategory);
    
    /**
     * Crea un nuevo producto.
     *
     * @param p El producto a crear.
     * @return Un mensaje indicando si la creación fue exitosa o no.
     */
    String postProduct (Product p);
    
    /**
     * Elimina un producto específico por su ID.
     *
     * @param strId El ID como cadena del producto a eliminar.
     * @return Un mensaje indicando si la eliminación fue exitosa o no.
     */
    String deleteProduct (String strId);
    
    /**
     * Actualiza un producto existente por su ID.
     *
     * @param p La nueva información del producto.
     * @param strId    El ID del producto a actualizar.
     * @return Un mensaje indicando si la actualización fue exitosa o no.
     */
    String putProduct (Product p, String strId);
    
    /**
     * Obtiene un objeto desde un formato JSON
     *
     * @param <T>
     * @param reference
     * @param json El ID de la orden a procesar.
     * @return devuelve el objeto mapeado en caso de exito, null si algo paso
     */
    <T> T getData (String json, TypeReference<T> reference);
}

