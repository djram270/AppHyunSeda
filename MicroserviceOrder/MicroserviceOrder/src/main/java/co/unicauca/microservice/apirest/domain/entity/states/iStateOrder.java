package co.unicauca.microservice.apirest.domain.entity.states;

import co.unicauca.microservice.apirest.domain.entity.Order;

public interface iStateOrder {
    /**
     * Cambia el estado de la orden (order) con la accion 'Cancel' [dependiendo de la logica implementada en el estado actual de la maquina].
     *
     * @param order Contexto de la maquina de estados.
     */
    void CancelOrder(Order order);
    /**
     * Cambia el estado de la orden (order) con la accion 'Send' [dependiendo de la logica implementada en el estado actual de la maquina].
     *
     * @param order Contexto de la maquina de estados.
     */
    void SendOrder(Order order);
    /**
     * Cambia el estado de la orden (order) con la accion 'NotSend' [dependiendo de la logica implementada en el estado actual de la maquina].
     *
     * @param order Contexto de la maquina de estados.
     */
    void NotSendOrder(Order order);
    /**
     * Cambia el estado de la orden (order) con la accion 'OnHold' [dependiendo de la logica implementada en el estado actual de la maquina].
     *
     * @param order Contexto de la maquina de estados.
     */
    void OnHoldOrder(Order order);
}
