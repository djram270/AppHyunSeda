package co.unicauca.hyunseda.admin.presentation;

import co.unicauca.hyunseda.admin.access.microservice.iMicroserviceUser;
import co.unicauca.hyunseda.admin.access.microservice.implementation.MicroserviceCategory;
import co.unicauca.hyunseda.admin.access.microservice.implementation.MicroserviceUser;
import co.unicauca.hyunseda.admin.domain.entities.AuthResponse;
import co.unicauca.hyunseda.admin.domain.entities.Category;
import co.unicauca.hyunseda.admin.domain.entities.LoginRequest;
import co.unicauca.hyunseda.admin.domain.entities.Product;
import co.unicauca.hyunseda.admin.domain.services.CategoryService;
import co.unicauca.hyunseda.admin.domain.services.ProductService;
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


//        LoginRequest login = new LoginRequest("tu", "123456");
//        iMicroserviceUser auth = new MicroserviceUser();
//        AuthResponse response = auth.login(login);
//        
//        System.out.println("token: " + response.getToken());
//        
//        ProductService productService = ProductService.getProductService(response.getToken());
//        CategoryService categoryService = CategoryService.getCategoryService();
//        
//        List<Category> categories = categoryService.getCategories();
//        //System.out.println(categories.toString());
//        Product p = new Product(0L, "nombre1", "description1", 70.0, 8, categories, "strLink1");
//        System.out.println("result: " + productService.postProduct(p));
        GUILogin guiClient = new GUILogin();
        guiClient.setVisible(true);
    }
}
