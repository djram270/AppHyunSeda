package co.unicauca.microservice.apirest.inputAdapter;

import co.unicauca.microservice.apirest.inputPort.iCategoryService;
import co.unicauca.microservice.apirest.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para las operaciones relacionadas con las categorías.
 *
 * Este controlador proporciona endpoints para realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre las categorías.
 */
@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RestController
@RequestMapping("/Categories")
@RequiredArgsConstructor
public class CategoryController {

    /** Servicio de categoría */
    @Autowired
    private iCategoryService categoryService;

    /**
     * Endpoint para crear una nueva categoría.
     *
     * @param category La categoría que se va a crear.
     * @return La respuesta con el estado HTTP y el mensaje correspondientes.
     */
    @Secured("ADMIN")
    @PostMapping("/post")
    public ResponseEntity<String> postProduct(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.postCategory(category));
    }

    /**
     * Endpoint para obtener todas las categorías.
     *
     * @return La respuesta con el estado HTTP y la lista de categorías.
     */
    @GetMapping("/get")
    public ResponseEntity<List<Category>> getProducts() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    /**
     * Endpoint para obtener una categoría por su ID.
     *
     * @param id El ID de la categoría que se desea obtener.
     * @return La respuesta con el estado HTTP y la categoría correspondiente.
     */
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Category> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    /**
     * Endpoint para obtener una categoría por su nombre.
     *
     * @param name El nombre de la categoría que se desea obtener.
     * @return La respuesta con el estado HTTP y la categoría correspondiente.
     */
    @GetMapping("/get/name/{name}")
    public ResponseEntity<Category> getProduct(@PathVariable String name) {
        return ResponseEntity.ok(categoryService.getCategoryByName(name));
    }

    /**
     * Endpoint para eliminar una categoría por su ID.
     *
     * @param id El ID de la categoría que se desea eliminar.
     * @return La respuesta con el estado HTTP y el mensaje correspondientes.
     */
    @Secured("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

    /**
     * Endpoint para actualizar una categoría por su ID.
     *
     * @param category La categoría actualizada.
     * @param id El ID de la categoría que se desea actualizar.
     * @return La respuesta con el estado HTTP y el mensaje correspondientes.
     */
    @Secured("ADMIN")
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putProduct(@RequestBody Category category, @PathVariable Long id) {
        return ResponseEntity.ok(categoryService.putCategory(category, id));
    }
}