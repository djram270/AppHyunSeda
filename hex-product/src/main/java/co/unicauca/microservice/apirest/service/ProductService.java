package co.unicauca.microservice.apirest.service;

import co.unicauca.microservice.apirest.inputPort.iCategoryService;
import co.unicauca.microservice.apirest.inputPort.iProductService;
import co.unicauca.microservice.apirest.model.Product;
import co.unicauca.microservice.apirest.outPutPort.iProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Servicio para operaciones relacionadas con los productos.
 *
 * Este servicio proporciona métodos para realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre los productos.
 */
@Configuration
@RequiredArgsConstructor
@Service
public class ProductService implements iProductService {

    /** Repositorio de productos */
    @Autowired
    private iProductRepository productRepository;

    /** Servicio de categorías */
    @Autowired
    private iCategoryService categoryService;

    @Override
    public List<Product> getProducts() {
        // La interfaz JPA ya proporciona métodos predeterminados para usar aquí
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductByCategory(String nameCategory) {
        return productRepository.findByCategory(nameCategory);
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product was deleted successfully";
    }

    @Override
    public String postProduct(Product product) {
        productRepository.save(product);
        return "Product was created successfully";
    }

    @Override
    public String putProduct(Product product, Long id) {
        Product p = productRepository.findById(id).orElse(null);

        if (p == null) {
            return "Product was not updated, an error has occurred";
        }
        product.setProductId(id);
        product.setCategories(categoryService.categoriesExisting(product.getCategories()));

        // Actualizar el producto con las categorías encontradas o creadas
        productRepository.save(product);

        return "Product was updated successfully";
    }
}