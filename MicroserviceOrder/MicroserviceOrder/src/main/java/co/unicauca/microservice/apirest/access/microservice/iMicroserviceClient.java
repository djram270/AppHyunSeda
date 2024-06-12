package co.unicauca.microservice.apirest.access.microservice;

import co.unicauca.microservice.apirest.access.model.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 * Interfaz para el cliente de microservicios.
 *
 * Esta interfaz define los métodos para interactuar con un servicio de microservicios.
 */
public interface iMicroserviceClient {

    /**
     * Obtiene la lista de clientes.
     *
     * @return La lista de clientes.
     */
    List<Client> getClients();

    /**
     * Obtiene un cliente por su identificador.
     *
     * @param strId El identificador del cliente.
     * @return El cliente correspondiente al identificador especificado.
     */
    Client getClient(String strId);

    /**
     * Publica un cliente.
     *
     * @param p El cliente que se desea publicar.
     * @return Un mensaje de confirmación sobre la publicación del cliente.
     */
    String postClient(Client p);

    /**
     * Elimina un cliente por su identificador.
     *
     * @param strId El identificador del cliente que se desea eliminar.
     * @return Un mensaje de confirmación sobre la eliminación del cliente.
     */
    String deleteClient(String strId);

    /**
     * Actualiza un cliente.
     *
     * @param p El cliente actualizado.
     * @param strId El identificador del cliente que se desea actualizar.
     * @return Un mensaje de confirmación sobre la actualización del cliente.
     */
    String putClient(Client p, String strId);

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