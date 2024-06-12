package co.unicauca.microservice.apirest.domain.entity.states;

import co.unicauca.microservice.apirest.access.Messages;
import co.unicauca.microservice.apirest.domain.entity.Order;

/**
 * Implementación de la interfaz {@link iStateOrder} para el estado de orden no enviada.
 * Este estado representa una orden que está lista para ser enviada pero aún no se ha enviado.
 */
public class NotSend implements iStateOrder {

    /**
     * Cambia el estado de la orden a "Cancelada".
     *
     * @param order La orden que se está cancelando.
     */
    @Override
    public void CancelOrder(Order order) {
        order.setState(new Cancel());
    }

    /**
     * No se puede enviar una orden que ya está lista para ser enviada.
     *
     * @param order La orden que se intenta enviar.
     */
    @Override
    public void SendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    /**
     * No se pueden realizar transiciones adicionales en una orden que ya está lista para ser enviada.
     *
     * @param order La orden en la que se intenta realizar la transición.
     */
    @Override
    public void NotSendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    /**
     * Cambia el estado de la orden a "En espera" y envía un mensaje de confirmación de pago.
     *
     * @param order La orden que se está poniendo en espera.
     */
    @Override
    public void OnHoldOrder(Order order) {
        Messages.sendPaymentConfirmationMessage();
        order.setState(new OnHold());
    }
}
