package co.unicauca.microservice.apirest.access.microservice;

import co.unicauca.microservice.apirest.access.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 * Interface defining operations for a Product microservice.
 */
public interface iMicroserviceProduct {

    /**
     * Retrieves all products.
     *
     * @return A list of all products.
     */
    List<Product> getProducts();

    /**
     * Retrieves a product by its ID.
     *
     * @param strId The string representation of the product ID.
     * @return The product with the specified ID, or null if not found.
     */
    Product getProduct(String strId);

    /**
     * Creates a new product.
     *
     * @param p The product object to be created.
     * @return A message indicating the result of the creation operation.
     */
    String postProduct(Product p);

    /**
     * Deletes a product by its ID.
     *
     * @param strId The string representation of the product ID.
     * @return A message indicating the result of the deletion operation.
     */
    String deleteProduct(String strId);

    /**
     * Updates an existing product with the specified ID.
     *
     * @param p The updated product object.
     * @param strId The string representation of the product ID.
     * @return A message indicating the result of the update operation.
     */
    String putProduct(Product p, String strId);

    /**
     * Converts a JSON string to a specified type using Jackson's TypeReference.
     *
     * @param json The JSON string to deserialize.
     * @param reference The TypeReference representing the target type.
     * @param <T> The type of the object to deserialize.
     * @return The deserialized object of the specified type.
     */
    <T> T getData(String json, TypeReference<T> reference);
}
