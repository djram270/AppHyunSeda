package co.unicauca.hyunseda.admin.presentation;

import co.unicauca.hyunseda.admin.access.microservice.implementation.MicroserviceCategory;
import co.unicauca.hyunseda.admin.access.model.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class main {
    public static void main(String[] args) {

//        MicroserviceCategory jackson = new MicroserviceCategory();
//        jackson.postCategory(new Category (0L, "ct3"));
//        List<Category> categories = jackson.getCategories();
//        
//        System.out.println(categories.toString());

//        /*
//        Product p = new Product(0L, "nombre1", "description1", 70.0, categories, "strLink1");
//        jackson.postProduct(p);
//        p = new Product(0L, "nombre2", "description2", 80.0, categories, "strLink2");
//        jackson.postProduct(p);
//        p = new Product(0L, "nombre2", "description2", 90.0, categories, "strLink2");
//        jackson.postProduct(p);*/
//        
//        //jackson.putProduct(p, "2");
//        
//        List<Product> products = jackson.getProducts();
//        Product p;
//        p = jackson.getProduct("2");
//        
//        System.out.println(products.toString());
//        System.out.println(p.toString());
        
        GUILogin guiClient = new GUILogin();
        guiClient.setVisible(true);
    }
}
