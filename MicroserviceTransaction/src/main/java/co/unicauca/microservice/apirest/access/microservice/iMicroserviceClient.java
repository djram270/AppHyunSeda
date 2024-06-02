package co.unicauca.microservice.apirest.access.microservice;

import co.unicauca.microservice.apirest.access.model.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 * Interfaz que define las operaciones disponibles para interactuar con el mircroservicio de clientes.
 */
public interface iMicroserviceClient {

    /**
     * Obtiene todos los clientes disponibles.
     * @return Una lista de todos los clientes existentes.
     */
    List<Client> getClients();

    /**
     * Obtiene un cliente específico por su ID.
     * @param strId El ID del cliente a recuperar.
     * @return El cliente correspondiente al ID especificado, o null si no se encontró ningún cliente con ese ID.
     */
    Client getClient(String strId);

    /**
     * Crea un nuevo cliente.
     * @param p El cliente a crear.
     * @return Un mensaje indicando si la creación fue exitosa o no.
     */
    String postClient(Client p);

    /**
     * Elimina un cliente específico por su ID.
     * @param strId El ID del cliente a eliminar.
     * @return Un mensaje indicando si la eliminación fue exitosa o no.
     */
    String deleteClient(String strId);

    /**
     * Actualiza un cliente existente por su ID.
     * @param p     La nueva información del cliente.
     * @param strId El ID del cliente a actualizar.
     * @return Un mensaje indicando si la actualización fue exitosa o no.
     */
    String putClient(Client p, String strId);

    /**
     * Obtiene datos de un JSON y los convierte en el tipo especificado por la referencia.
     * @param json      El JSON del que se van a obtener los datos.
     * @param reference Referencia de tipo para convertir el JSON en un objeto Java.
     * @return Objeto del tipo especificado obtenido del JSON.
     */
    <T> T getData(String json, TypeReference<T> reference);
}