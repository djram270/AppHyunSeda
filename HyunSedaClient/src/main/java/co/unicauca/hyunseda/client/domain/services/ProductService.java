package co.unicauca.hyunseda.client.domain.services;

import co.unicauca.hyunseda.client.access.microservice.iMicroserviceProduct;
import co.unicauca.hyunseda.client.access.microservice.implementation.MicroserviceProduct;
import co.unicauca.hyunseda.client.access.model.Product;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class ProductService {
    
    private static ProductService productService;
    private iMicroserviceProduct microserviceProduct;
    
    private ProductService ()
    {
        microserviceProduct = new MicroserviceProduct();
    }
    
    public static ProductService getProductService ()
    {
        if (productService == null)
        {
            productService = new ProductService();
        }
        return productService;
    }
    
    public List<Product> getProducts()
    {
        return microserviceProduct.getProducts();
    }
    
    public List<Product> getProductsByName(String nameProduct)
    {
        return microserviceProduct.getProductName(nameProduct);
    }
    
    public Product getProductById(Long id)
    {
        return microserviceProduct.getProduct(id.toString());
    }
}
