package co.unicauca.microservice.apirest.inputAdapter;

import co.unicauca.microservice.apirest.inputPort.iProductService;
import co.unicauca.microservice.apirest.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controlador para las operaciones relacionadas con los productos.
 *
 * Este controlador proporciona endpoints para realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre los productos.
 */
@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RestController
@RequestMapping("/Products")
@RequiredArgsConstructor
public class ProductController {

    /** Servicio de producto */
    @Autowired
    private iProductService productService;

    /**
     * Endpoint para crear un nuevo producto.
     *
     * @param product El producto que se va a crear.
     * @return La respuesta con el estado HTTP y el mensaje correspondientes.
     */
    @Secured("ADMIN")
    @PostMapping("/post")
    public ResponseEntity<String> postProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.postProduct(product));
    }

    /**
     * Endpoint para obtener todos los productos.
     *
     * @return La respuesta con el estado HTTP y la lista de productos.
     */
    @GetMapping("/get")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    /**
     * Endpoint para obtener un producto por su ID.
     *
     * @param id El ID del producto que se desea obtener.
     * @return La respuesta con el estado HTTP y el producto correspondiente.
     */
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    /**
     * Endpoint para obtener productos por su nombre.
     *
     * @param name El nombre del producto que se desea obtener.
     * @return La respuesta con el estado HTTP y la lista de productos correspondientes.
     */
    @GetMapping("/get/name/{name}")
    public ResponseEntity<List<Product>> getProductName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    /**
     * Endpoint para obtener productos por su categoría.
     *
     * @param nameCategory El nombre de la categoría de los productos que se desea obtener.
     * @return La respuesta con el estado HTTP y la lista de productos correspondientes.
     */
    @GetMapping("/get/category/{nameCategory}")
    public ResponseEntity<List<Product>> getProductCategory(@PathVariable String nameCategory) {
        return ResponseEntity.ok(productService.getProductByCategory(nameCategory));
    }

    /**
     * Endpoint para eliminar un producto por su ID.
     *
     * @param id El ID del producto que se desea eliminar.
     * @return La respuesta con el estado HTTP y el mensaje correspondientes.
     */
    @Secured("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    /**
     * Endpoint para actualizar un producto por su ID.
     *
     * @param product El producto actualizado.
     * @param id El ID del producto que se desea actualizar.
     * @return La respuesta con el estado HTTP y el mensaje correspondientes.
     */
    @Secured("ADMIN")
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putProduct(@RequestBody Product product, @PathVariable Long id) {
        return ResponseEntity.ok(productService.putProduct(product, id));
    }
}