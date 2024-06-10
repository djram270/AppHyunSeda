package co.unicauca.microservice.apirest.inputPort;

import co.unicauca.microservice.apirest.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface iProductService {
    List<Product> getProducts();
    Product getProduct(Long id);
    List<Product> getProductByName(String name);
    List<Product> getProductByCategory(String nameCategory);
    String deleteProduct(Long id);
    String postProduct(Product product);
    String putProduct(Product product, Long id);
}
