package co.unicauca.microservice.apirest.domain.service.implementation;

import co.unicauca.microservice.apirest.domain.entity.Order;
import co.unicauca.microservice.apirest.domain.service.iOrderService;
import co.unicauca.microservice.apirest.repository.iOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Un servicio para realizar operaciones CRUD en las órdenes y ejecutar acciones en ellas.
 */
@Service
@RequiredArgsConstructor
public class OrderService implements iOrderService {
    /**
     * El repositorio utilizado para acceder a los datos de las órdenes.
     */
    @Autowired
    private iOrderRepository orderRepository;

    /**
     * Recupera todas las órdenes.
     *
     * @return Una lista de todas las órdenes.
     */
    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    /**
     * Recupera una orden por su identificador.
     *
     * @param id El identificador de la orden a recuperar.
     * @return La orden recuperada, o null si no se encuentra.
     */
    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    /**
     * Recupera todas las órdenes con un estado específico.
     *
     * @param strState El estado de las órdenes a recuperar.
     * @return Una lista de órdenes con el estado especificado.
     */
    @Override
    public List<Order> getOrdersByStrState(String strState) {
        return orderRepository.findByStrState(strState);
    }

    /**
     * Elimina una orden por su identificador.
     *
     * @param id El identificador de la orden a eliminar.
     * @return Un mensaje indicando el resultado de la operación de eliminación.
     */
    @Override
    public String deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return "Order was deleted successfully";
    }

    /**
     * Crea una nueva orden.
     *
     * @param order La orden a crear.
     * @return Un mensaje indicando el resultado de la operación de creación.
     */
    @Override
    public String postOrder(Order order) {
        orderRepository.save(order);
        return "Order was created successfully";
    }

    /**
     * Actualiza una orden existente.
     *
     * @param order La orden actualizada.
     * @param id    El identificador de la orden a actualizar.
     * @return Un mensaje indicando el resultado de la operación de actualización.
     */
    @Override
    public String putOrder(Order order, Long id) {
        Order o = orderRepository.findById(id).orElse(null);

        if (o == null) {
            return "Order was not updated, an error has occurred";
        }
        order.setOrderId(o.getOrderId());
        orderRepository.save(order);
        return "Order was updated successfully";
    }

    /**
     * Ejecuta la acción de "no enviar" en una orden.
     *
     * @param id El identificador de la orden en la que se ejecuta la acción.
     * @return true si la acción se ejecuta con éxito, false si ocurre algún error.
     */
    @Override
    public boolean executeNotSendInOrder(Long id) {
        Order o = getOrder(id);

        if (o == null) {
            return false;
        }

        o.setPersistentState();
        o.notSendOrder();
        orderRepository.save(o);
        return true;
    }

    /**
     * Ejecuta la acción de "en espera" en una orden.
     *
     * @param id El identificador de la orden en la que se ejecuta la acción.
     * @return true si la acción se ejecuta con éxito, false si ocurre algún error.
     */
    @Override
    public boolean executeOnHoldInOrder(Long id) {
        Order o = getOrder(id);

        if (o == null) {
            return false;
        }

        o.setPersistentState();
        o.onHold();
        orderRepository.save(o);
        return true;
    }

    /**
     * Ejecuta la acción de "enviar" en una orden.
     *
     * @param id El identificador de la orden en la que se ejecuta la acción.
     * @return true si la acción se ejecuta con éxito, false si ocurre algún error.
     */
    @Override
    public boolean executeSendInOrder(Long id) {
        Order o = getOrder(id);

        if (o == null) {
            return false;
        }

        o.setPersistentState();
        o.sendOrder();
        orderRepository.save(o);
        return true;
    }

    /**
     * Ejecuta la acción de "cancelar" en una orden.
     *
     * @param id El identificador de la orden en la que se ejecuta la acción.
     * @return true si la acción se ejecuta con éxito, false si ocurre algún error.
     */
    @Override
    public boolean executeCancelInOrder(Long id) {
        Order o = getOrder(id);

        if (o == null) {
            return false;
        }

        o.setPersistentState();
        o.cancelOrder();
        orderRepository.save(o);
        return true;
    }
}
