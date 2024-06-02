package co.unicauca.microservice.apirest.access.microservice;

import co.unicauca.microservice.apirest.access.model.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 * Interface defining operations for a Client microservice.
 */
public interface iMicroserviceClient {

    /**
     * Retrieves all clients.
     *
     * @return A list of all clients.
     */
    List<Client> getClients();

    /**
     * Retrieves a client by its ID.
     *
     * @param strId The string representation of the client ID.
     * @return The client with the specified ID, or null if not found.
     */
    Client getClient(String strId);

    /**
     * Creates a new client.
     *
     * @param p The client object to be created.
     * @return A message indicating the result of the creation operation.
     */
    String postClient(Client p);

    /**
     * Deletes a client by its ID.
     *
     * @param strId The string representation of the client ID.
     * @return A message indicating the result of the deletion operation.
     */
    String deleteClient(String strId);

    /**
     * Updates an existing client with the specified ID.
     *
     * @param p The updated client object.
     * @param strId The string representation of the client ID.
     * @return A message indicating the result of the update operation.
     */
    String putClient(Client p, String strId);

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
