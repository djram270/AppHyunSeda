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

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RestController
@RequestMapping("/Products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private iProductService productService;

    @Secured("ADMIN")
    @PostMapping("/post")
    public ResponseEntity<String> postProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.postProduct(product));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.getProduct(id));
    }
    @GetMapping("/get/name/{name}")
    public ResponseEntity<List<Product>> getProductName(@PathVariable String name)
    {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/get/category/{nameCategory}")
    public ResponseEntity<List<Product>> getProductCategory(@PathVariable String nameCategory)
    {
        return ResponseEntity.ok(productService.getProductByCategory(nameCategory));
    }
    @Secured("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
    @Secured("ADMIN")
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putProduct(@RequestBody Product product, @PathVariable Long id)
    {
        return ResponseEntity.ok(productService.putProduct(product, id));
    }
}