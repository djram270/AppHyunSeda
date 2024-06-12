package co.unicauca.microservice.apirest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.unicauca.microservice.apirest.domain.entity.Order;
import co.unicauca.microservice.apirest.domain.service.iOrderService;

import java.util.List;
/**
 * Controlador REST para gestionar las órdenes.
 *
 * Este controlador proporciona endpoints para realizar operaciones CRUD en las órdenes.
 */
@RestController
@RequestMapping("/Orders")
@RequiredArgsConstructor
public class OrderController {

    /** Servicio de órdenes */
    @Autowired
    private iOrderService orderService;

    /**
     * Crea una nueva orden.
     *
     * @param order La orden que se desea crear.
     * @return Una respuesta HTTP indicando el resultado de la operación.
     */
    @PostMapping("/post")
    public ResponseEntity<String> posOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.postOrder(order));
    }

    /**
     * Obtiene todas las órdenes.
     *
     * @return Una respuesta HTTP con la lista de órdenes.
     */
    @GetMapping("/get")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    /**
     * Obtiene una orden por su identificador.
     *
     * @param id El identificador de la orden que se desea obtener.
     * @return Una respuesta HTTP con la orden correspondiente.
     */
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    /**
     * Obtiene todas las órdenes con un estado específico.
     *
     * @param strState El estado de las órdenes que se desean obtener.
     * @return Una respuesta HTTP con la lista de órdenes correspondiente al estado especificado.
     */
    @GetMapping("/get/state/{strState}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable String strState) {
        return ResponseEntity.ok(orderService.getOrdersByStrState(strState));
    }

    /**
     * Elimina una orden por su identificador.
     *
     * @param id El identificador de la orden que se desea eliminar.
     * @return Una respuesta HTTP indicando el resultado de la operación.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }

    /**
     * Actualiza una orden.
     *
     * @param order La orden actualizada.
     * @param id El identificador de la orden que se desea actualizar.
     * @return Una respuesta HTTP indicando el resultado de la operación.
     */
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putOrder(@RequestBody Order order, @PathVariable Long id) {
        return ResponseEntity.ok(orderService.putOrder(order, id));
    }

    // Endpoints adicionales para ejecutar acciones en las órdenes...

}