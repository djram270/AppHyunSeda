package co.unicauca.microservice.apirest.domain.entity.states;

import co.unicauca.microservice.apirest.access.Messages;
import co.unicauca.microservice.apirest.domain.entity.Order;
/**
 * Implementación de la interfaz {@link iStateOrder} para el estado de orden en espera.
 * Este estado representa una orden que está en espera de confirmación o acciones adicionales antes de ser enviada.
 */
public class OnHold implements iStateOrder {

    /**
     * No se puede cancelar una orden que ya está en espera.
     *
     * @param order La orden que se está intentando cancelar.
     */
    @Override
    public void CancelOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    /**
     * Cambia el estado de la orden a "Enviada" y envía una confirmación de envío.
     *
     * @param order La orden que se está enviando.
     */
    @Override
    public void SendOrder(Order order) {
        //Messages.sendPaymentConfirmationMessage();
        System.out.println("The product was send");
        order.setState(new Send());
    }

    /**
     * Cambia el estado de la orden a "No enviada".
     *
     * @param order La orden que se está marcando como no enviada.
     */
    @Override
    public void NotSendOrder(Order order) {
        order.setState(new NotSend());
    }

    /**
     * No se pueden realizar transiciones adicionales en una orden que ya está en espera.
     *
     * @param order La orden en la que se intenta realizar la transición.
     */
    @Override
    public void OnHoldOrder(Order order) {
        System.out.println("This transition does not exist");
    }
}
