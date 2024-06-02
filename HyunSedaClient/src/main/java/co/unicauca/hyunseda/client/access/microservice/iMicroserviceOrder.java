/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.client.access.microservice;

import co.unicauca.hyunseda.client.access.model.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 *
 * @author dizu8
 */
public interface iMicroserviceOrder {
    /**
     * Obtiene todas las órdenes disponibles.
     *
     * @return Una lista de todas las órdenes.
     */
    List<Order> getOrders();

    /**
     * Obtiene una orden específica por su ID.
     *
     * @param strId El ID como cadena de la orden a recuperar.
     * @return La orden correspondiente al ID especificado, o null si no se encontró ninguna orden con ese ID.
     */
    Order getOrder(String strId);
    
    /**
     * Elimina una orden específica por su ID.
     *
     * @param strState El estado como cadena de las ordenes a buscar.
     * @return Lista de ordenes con el estado buscado.
     */
    List<Order> getOrdersByStrState(String strState);

    /**
     * Elimina una orden específica por su ID.
     *
     * @param strId El ID como cadena de la orden a eliminar.
     * @return Un mensaje indicando si la eliminación fue exitosa o no.
     */
    String deleteOrder(String strId);

    /**
     * Crea una nueva orden.
     *
     * @param order La orden a crear.
     * @return Un mensaje indicando si la creación fue exitosa o no.
     */
    String postOrder(Order order);

    /**
     * Actualiza una orden existente por su ID.
     *
     * @param order La nueva información de la orden.
     * @param strId El ID de la orden a actualizar.
     * @return Un mensaje indicando si la actualización fue exitosa o no.
     */
    String putOrder(Order order, String strId);
    /**
     * Ejecuta la accion 'NotSend' sobre el estado en el que se encuentre la orden.
     *
     * @param strId El ID de la orden a procesar.
     * @return true si la orden se marcó correctamente como no enviada, false si la orden no se encontró.
     */
    String executeNotSendInOrder(String strId);

    /**
     * Ejecuta la accion 'OnHold' sobre el estado en el que se encuentre la orden existente en la base de datos.
     *
     * @param strId El ID de la orden a procesar.
     * @return true si se ejecuto la accion sobre la orden, false si la orden no se encontró.
     */
    String executeOnHoldInOrder(String strId);

    /**
     * Ejecuta la accion 'Send' sobre el estado en el que se encuentre la orden existente en la base de datos.
     *
     * @param strId El ID de la orden a procesar.
     * @return true si se ejecuto la accion sobre la orden, false si la orden no se encontró.
     */
    String executeSendInOrder(String strId);

    /**
     * Ejecuta la accion 'Cancel' sobre el estado en el que se encuentre la orden existente en la base de datos.
     *
     * @param strId El ID de la orden a procesar.
     * @return true si se ejecuto la accion sobre la orden, false si la orden no se encontró.
     */
    String executeCancelInOrder(String strId);
    
    /**
     * Obtiene un objeto desde un formato JSON
     *
     * @param <T>
     * @param reference
     * @param json El ID de la orden a procesar.
     * @return devuelve el objeto mapeado en caso de exito, null si algo paso
     */
    <T> T getData(String json, TypeReference<T> reference);
}
