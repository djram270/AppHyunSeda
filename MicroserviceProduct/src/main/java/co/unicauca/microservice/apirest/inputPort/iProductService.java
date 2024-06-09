package co.unicauca.microservice.apirest.inputPort;

import java.util.List;

import co.unicauca.microservice.apirest.model.Product;

public interface iProductService {
    List<Product> getProducts();
    Product getProduct(Long id);
    List<Product> getProductByName(String name);
    List<Product> getProductByCategory(String nameCategory);
    String deleteProduct(Long id);
    String postProduct(Product product);
    String putProduct(Product product, Long id);
}
