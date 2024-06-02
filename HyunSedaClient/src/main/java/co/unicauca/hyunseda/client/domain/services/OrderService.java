package co.unicauca.hyunseda.client.domain.services;

import co.unicauca.hyunseda.client.access.microservice.iMicroserviceOrder;
import co.unicauca.hyunseda.client.access.microservice.implementation.MicroserviceOrder;
import co.unicauca.hyunseda.client.access.model.Order;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class OrderService {
    private static OrderService orderService;
    private iMicroserviceOrder microserviceOrder;
    
    private OrderService ()
    {
        microserviceOrder = new MicroserviceOrder();
    }
    
    public static OrderService getOrderService ()
    {
        if (orderService == null)
        {
            orderService = new OrderService();
        }
        return orderService;
    }
    
    public List<Order> getOrders()
    {
        return microserviceOrder.getOrders();
    }
    
    public Order getOrderById(Long id)
    {
        return microserviceOrder.getOrder(id.toString());
    }
    
    public List<Order> getOrderByState(String strState)
    {
        return microserviceOrder.getOrdersByStrState(strState);
    }
    
    public String postOrder(Order order)
    {
        return microserviceOrder.postOrder(order);
    }
    
    public String executeNotSendInOrder(String strId) {
        return microserviceOrder.executeNotSendInOrder(strId);
    }
    
    public String executeOnHoldInOrder(String strId) {
        return microserviceOrder.executeOnHoldInOrder(strId);
    }
    
    public String executeSendInOrder(String strId) {
        return microserviceOrder.executeSendInOrder(strId);
    }
    
    public String executeCancelInOrder(String strId) {
        
        return microserviceOrder.executeCancelInOrder(strId);
    }
    

    
    public boolean putOrder(Order p, String strId)
    {
        return microserviceOrder.putOrder(p, strId).contains("successfully");
    }
}