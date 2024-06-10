package co.unicauca.hyunseda.admin.domain.services;

import co.unicauca.hyunseda.admin.access.microservice.iMicroserviceProduct;
import co.unicauca.hyunseda.admin.access.microservice.implementation.MicroserviceProduct;
import co.unicauca.hyunseda.admin.domain.entities.Product;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class ProductService {
    
    private static ProductService productService;
    private static iMicroserviceProduct microserviceProduct;
    private static String authToken;
    
    private ProductService (String authToken)
    {
        this.authToken = authToken;
        microserviceProduct = new MicroserviceProduct(this.authToken);
    }
    
    private ProductService ()
    {
        //evitar el uso del servicio mientras no haya token
        if (authToken != null)
        {
            microserviceProduct = new MicroserviceProduct(authToken);
        }
    }
    
    public static ProductService getProductService (String authToken)
    {
        if (productService == null)
        {
            productService = new ProductService(authToken);
        }
        ProductService.authToken = authToken;
        microserviceProduct.setAuthToken(authToken);
        return productService;
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
    
    public Product getProductById(String strId)
    {
        return microserviceProduct.getProduct(strId);
    }
    
    public boolean postProduct(Product p)
    {
        return microserviceProduct.postProduct(p).contains("successfully");
    }
    
        public boolean deleteProduct(String strId)
    {
        return microserviceProduct.deleteProduct(strId).contains("successfully");
    }
    
    public boolean putProduct(Product p, String strId)
    {
        return microserviceProduct.putProduct(p, strId).contains("successfully");
    }
}
