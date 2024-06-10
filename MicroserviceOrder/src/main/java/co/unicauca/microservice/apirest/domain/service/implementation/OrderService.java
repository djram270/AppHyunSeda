package co.unicauca.microservice.apirest.domain.service.implementation;

import co.unicauca.microservice.apirest.domain.entity.Order;
import co.unicauca.microservice.apirest.domain.service.iOrderService;
import co.unicauca.microservice.apirest.repository.iOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderService implements iOrderService {
    @Autowired
    private iOrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    @Override
    public List<Order> getOrdersByStrState(String strState) {
        return orderRepository.findByStrState(strState);
    }
    @Override
    public String deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return "Order was deleted successfully";
    }
    @Override
    public String postOrder(Order order) {
        orderRepository.save(order);
        return "Order was created successfully";
    }
    @Override
    public String putOrder(Order order, Long id) {
        Order o = orderRepository.findById(id).orElse(null);

        if (o == null)
        {
            return "Order was not updated, an error has occurred";
        }
        order.setOrderId(o.getOrderId());
        orderRepository.save(order);
        return "Order was updated successfully";
    }

    @Override
    public boolean executeNotSendInOrder(Long id) {
        Order o = getOrder(id);

        if (o == null){return false;}

        o.setPersistentState();
        o.notSendOrder();
        orderRepository.save(o);
        return true;
    }

    @Override
    public boolean executeOnHoldInOrder(Long id) {
        Order o = getOrder(id);

        if (o == null) {return false;}

        o.setPersistentState();
        o.onHold();
        orderRepository.save(o);
        return true;
    }

    @Override
    public boolean executeSendInOrder(Long id) {
        Order o = getOrder(id);

        if (o == null){return false;}

        o.setPersistentState();
        o.sendOrder();
        orderRepository.save(o);
        return true;
    }

    @Override
    public boolean executeCancelInOrder(Long id) {
        Order o = getOrder(id);

        if (o == null){return false;}

        o.setPersistentState();
        o.cancelOrder();
        orderRepository.save(o);
        return true;
    }


}
