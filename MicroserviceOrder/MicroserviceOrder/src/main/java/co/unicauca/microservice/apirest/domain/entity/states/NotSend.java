package co.unicauca.microservice.apirest.domain.entity.states;

import co.unicauca.microservice.apirest.access.Messages;
import co.unicauca.microservice.apirest.domain.entity.Order;

public class NotSend implements iStateOrder{
    @Override
    public void CancelOrder(Order order) {
        order.setState(new Cancel());
    }

    @Override
    public void SendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    @Override
    public void NotSendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    @Override
    public void OnHoldOrder(Order order) {
        Messages.sendPaymentConfirmationMessage();
        order.setState(new OnHold());
    }
}
