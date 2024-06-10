/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.client.access.microservice;

import co.unicauca.hyunseda.client.access.model.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 *
 * @author dizu8
 */
public interface iMicroserviceClient {
    /**
     * Obtiene todos los clientes disponibles.
     *
     * @return Una lista de todos los clientes.
     */
    List<Client> getClients ();
    
    /**
     * Obtiene un cliente específico por su ID.
     *
     * @param strId El ID como cadena del cliente a recuperar.
     * @return El cliente correspondiente al ID especificado, o null si no se encontró ningun cliente con ese ID.
     */
    Client getClient (String strId);
    
    /**
     * Crea una nueva orden.
     *
     * @param p Registro de cliente a crear.
     * @return Un mensaje indicando si la creación fue exitosa o no.
     */
    String postClient (Client p);
    
    /**
     * Elimina un cliente específica por su ID.
     *
     * @param strId El ID como cadena del cliente a eliminar.
     * @return Un mensaje indicando si la eliminación fue exitosa o no.
     */
    String deleteClient (String strId);
    
    /**
     * Actualiza un registro de cliente existente por su ID.
     *
     * @param p La nueva información para el registro de cliente.
     * @param strId    El ID del registro de cliente a actualizar.
     * @return Un mensaje indicando si la actualización fue exitosa o no.
     */
    String putClient (Client p, String strId);
    
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
