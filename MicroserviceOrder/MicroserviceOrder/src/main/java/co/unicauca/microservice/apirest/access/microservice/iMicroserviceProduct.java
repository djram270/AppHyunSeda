package co.unicauca.microservice.apirest.access.microservice;

import co.unicauca.microservice.apirest.access.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public interface iMicroserviceProduct {
    List<Product> getProducts ();
    Product getProduct (String strId);
    String postProduct (Product p);
    String deleteProduct (String strId);
    String putProduct (Product p, String strId);
    <T> T getData (String json, TypeReference<T> reference);
}
