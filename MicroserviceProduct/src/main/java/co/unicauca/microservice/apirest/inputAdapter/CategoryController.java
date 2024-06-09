package co.unicauca.microservice.apirest.inputAdapter;

import co.unicauca.microservice.apirest.inputPort.iCategoryService;
import co.unicauca.microservice.apirest.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Categories")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private iCategoryService categoryService;

    @PostMapping("/post")
    public ResponseEntity<String> postProduct(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.postCategory(category));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Category>> getProducts() {
        return ResponseEntity.ok(categoryService.getCategories());
    }
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Category> getProduct(@PathVariable Long id)
    {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
    @GetMapping("/get/name/{name}")
    public ResponseEntity<Category> getProduct(@PathVariable String name)
    {
        return ResponseEntity.ok(categoryService.getCategoryByName(name));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id)
    {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putProduct(@RequestBody Category category, @PathVariable Long id)
    {
        return ResponseEntity.ok(categoryService.putCategory(category, id));
    }
}
