package co.unicauca.microservice.apirest.domain.service;

import java.util.List;

import co.unicauca.microservice.apirest.domain.entity.Order;

public interface iOrderService {
    /**
     * Obtiene todas las órdenes disponibles.
     *
     * @return Una lista de todas las órdenes.
     */
    List<Order> getOrders();

    /**
     * Obtiene una orden específica por su ID.
     *
     * @param id El ID de la orden a recuperar.
     * @return La orden correspondiente al ID especificado, o null si no se encontró ninguna orden con ese ID.
     */
    Order getOrder(Long id);

    /**
     * Obtiene una orden específica por su estado.
     *
     * @param strState El estado de la orden a recuperar.
     * @return Las ordenes correspondientes al estado.
     */
    List<Order> getOrdersByStrState(String strState);

    /**
     * Elimina una orden específica por su ID.
     *
     * @param id El ID de la orden a eliminar.
     * @return Un mensaje indicando si la eliminación fue exitosa o no.
     */
    String deleteOrder(Long id);

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
     * @param id    El ID de la orden a actualizar.
     * @return Un mensaje indicando si la actualización fue exitosa o no.
     */
    String putOrder(Order order, Long id);
    /**
     * Ejecuta la accion 'NotSend' sobre el estado en el que se encuentre la orden.
     *
     * @param id El ID de la orden a procesar.
     * @return true si la orden se marcó correctamente como no enviada, false si la orden no se encontró.
     */
    boolean executeNotSendInOrder(Long id);

    /**
     * Ejecuta la accion 'OnHold' sobre el estado en el que se encuentre la orden existente en la base de datos.
     *
     * @param id El ID de la orden a procesar.
     * @return true si se ejecuto la accion sobre la orden, false si la orden no se encontró.
     */
    boolean executeOnHoldInOrder(Long id);

    /**
     * Ejecuta la accion 'Send' sobre el estado en el que se encuentre la orden existente en la base de datos.
     *
     * @param id El ID de la orden a procesar.
     * @return true si se ejecuto la accion sobre la orden, false si la orden no se encontró.
     */
    boolean executeSendInOrder(Long id);

    /**
     * Ejecuta la accion 'Cancel' sobre el estado en el que se encuentre la orden existente en la base de datos.
     *
     * @param id El ID de la orden a procesar.
     * @return true si se ejecuto la accion sobre la orden, false si la orden no se encontró.
     */
    boolean executeCancelInOrder(Long id);
}
