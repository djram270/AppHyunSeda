package co.unicauca.microservice.apirest.domain.entity.states;

import co.unicauca.microservice.apirest.domain.entity.Order;

/**
 * Implementación de la interfaz {@link iStateOrder} para el estado de orden enviada.
 * Este estado representa una orden que ya ha sido enviada.
 */
public class Send implements iStateOrder {

    /**
     * No se puede cancelar una orden que ya ha sido enviada.
     *
     * @param order La orden que se está intentando cancelar.
     */
    @Override
    public void CancelOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    /**
     * No se pueden realizar transiciones adicionales en una orden que ya ha sido enviada.
     *
     * @param order La orden en la que se intenta realizar la transición.
     */
    @Override
    public void SendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    /**
     * No se pueden realizar transiciones adicionales en una orden que ya ha sido enviada.
     *
     * @param order La orden en la que se intenta realizar la transición.
     */
    @Override
    public void NotSendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    /**
     * No se pueden realizar transiciones adicionales en una orden que ya ha sido enviada.
     *
     * @param order La orden en la que se intenta realizar la transición.
     */
    @Override
    public void OnHoldOrder(Order order) {
        System.out.println("This transition does not exist");
    }
}
