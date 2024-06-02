package co.unicauca.microservice.apirest.controller;

import co.unicauca.microservice.apirest.model.entity.Product;
import co.unicauca.microservice.apirest.model.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Products")
@RequiredArgsConstructor
public class ProductController {
    //inyectar un servicio (innecesario, ahora se gestinona con @wired)
    @Autowired
    private iProductService productService;

    //@POST requiere una dependencia que no se tiene en el proyecto
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id)
    {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putProduct(@RequestBody Product product, @PathVariable Long id)
    {
        return ResponseEntity.ok(productService.putProduct(product, id));
    }
}