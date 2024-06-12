package co.unicauca.microservice.apirest.controller;

import co.unicauca.microservice.apirest.access.microservice.iMicroserviceProduct;
import co.unicauca.microservice.apirest.domain.entity.Item;
import co.unicauca.microservice.apirest.domain.entity.Order;
import co.unicauca.microservice.apirest.domain.service.iItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los ítems.
 *
 * Este controlador proporciona endpoints para realizar operaciones CRUD en los ítems.
 */
@RestController
@RequestMapping("/Items")
@RequiredArgsConstructor
public class ItemController {

    /** Servicio de ítems */
    @Autowired
    private iItemService itemService;

    /** Cliente del microservicio de productos */
    @Autowired
    private iMicroserviceProduct microserviceProduct;

    /**
     * Crea un nuevo ítem.
     *
     * @param item El ítem que se desea crear.
     * @return Una respuesta HTTP indicando el resultado de la operación.
     */
    @PostMapping("/post")
    public ResponseEntity<String> posItem(@RequestBody Item item) {
//        item.setProduct(microserviceProduct.getProduct(String.valueOf(item.getProduct().getProductId())));
        if (microserviceProduct.getProduct(String.valueOf(item.getProductId())) == null) {
            return ResponseEntity.ok("The item can't be created because the product correspondent doesn't exist");
        }
        return ResponseEntity.ok(itemService.postItem(item));
    }

    /**
     * Obtiene todos los ítems.
     *
     * @return Una respuesta HTTP con la lista de ítems.
     */
    @GetMapping("/get")
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(itemService.getItems());
    }

    /**
     * Obtiene un ítem por su identificador.
     *
     * @param id El identificador del ítem que se desea obtener.
     * @return Una respuesta HTTP con el ítem correspondiente.
     */
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Item> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

    /**
     * Elimina un ítem por su identificador.
     *
     * @param id El identificador del ítem que se desea eliminar.
     * @return Una respuesta HTTP indicando el resultado de la operación.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.deleteItem(id));
    }

    /**
     * Actualiza un ítem.
     *
     * @param item El ítem actualizado.
     * @param id El identificador del ítem que se desea actualizar.
     * @return Una respuesta HTTP indicando el resultado de la operación.
     */
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putItem(@RequestBody Item item, @PathVariable Long id) {
        return ResponseEntity.ok(itemService.putItem(item, id));
    }
}