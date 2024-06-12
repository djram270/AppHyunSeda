package co.unicauca.microservice.apirest.domain.entity.states;

import co.unicauca.microservice.apirest.domain.entity.Order;

/**
 * Implementación de la interfaz {@link iStateOrder} para el estado de cancelación de una orden.
 * Este estado representa una orden que ha sido cancelada.
 */
public class Cancel implements iStateOrder {

    /**
     * No se puede cancelar una orden que ya está en estado de cancelación.
     *
     * @param order La orden que se intenta cancelar.
     */
    @Override
    public void CancelOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    /**
     * No se puede enviar una orden que está en estado de cancelación.
     *
     * @param order La orden que se intenta enviar.
     */
    @Override
    public void SendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    /**
     * Cambia el estado de la orden a "No enviada".
     *
     * @param order La orden a la que se le cambiará el estado.
     */
    @Override
    public void NotSendOrder(Order order) {
        order.setState(new NotSend());
    }

    /**
     * No se puede poner en espera una orden que está en estado de cancelación.
     *
     * @param order La orden que se intenta poner en espera.
     */
    @Override
    public void OnHoldOrder(Order order) {
        System.out.println("This transition does not exist");
    }
}