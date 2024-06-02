package com.apirest.apirest.access.microservice;

import com.apirest.apirest.access.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
/**
 * Interface defining operations for a User microservice.
 */
public interface iMicroserviceUser {

    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    List<User> getUsers();

    /**
     * Retrieves a user by their ID.
     *
     * @param strId The string representation of the user ID.
     * @return The user with the specified ID, or null if not found.
     */
    User getUserById(String strId);

    /**
     * Creates a new user.
     *
     * @param p The user object to be created.
     * @return A message indicating the result of the creation operation.
     */
    String postUser(User p);

    /**
     * Deletes a user by their ID.
     *
     * @param strId The string representation of the user ID.
     * @return A message indicating the result of the deletion operation.
     */
    String deleteUser(String strId);

    /**
     * Updates an existing user with the specified ID.
     *
     * @param p The updated user object.
     * @param strId The string representation of the user ID.
     * @return A message indicating the result of the update operation.
     */
    String putUser(User p, String strId);

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