package co.unicauca.hyunseda.admin.access.microservice;

/**
 *
 * @author dizu8
 */

import co.unicauca.hyunseda.admin.access.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public interface iMicroserviceProduct {
    List<Product> getProducts ();
    Product getProduct (String strId);
    List<Product> getProductName (String strId);
    List<Product> getProductCategory (String strId);
    String postProduct (Product p);
    String deleteProduct (String strId);
    String putProduct (Product p, String strId);
    <T> T getData (String json, TypeReference<T> reference);
}

