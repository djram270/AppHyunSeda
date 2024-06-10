package co.unicauca.hyunseda.client.presentation;

import co.unicauca.hyunseda.client.access.microservice.implementation.MicroserviceProduct;
import co.unicauca.hyunseda.client.access.model.Category;
import co.unicauca.hyunseda.client.access.model.Item;
import co.unicauca.hyunseda.client.access.model.Order;
import co.unicauca.hyunseda.client.access.model.Product;
import co.unicauca.hyunseda.client.domain.services.OrderService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dizu8
 */
public class main {
    public static void main(String[] args) {

//        MicroserviceProduct jackson = new MicroserviceProduct();
//        
//        List<Category> categories = new ArrayList();
//        
//        categories.add(new Category(1L, ""));
//        categories.add(new Category(2L, ""));
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
//        System.out.println(products.toString());
//        System.out.println(p.toString());
        
//        GUILogin guiClient = new GUILogin();
//        guiClient.setSize(500, 500);
//        guiClient.setVisible(true);

//        List<Order> orders = OrderService.getOrderService().getOrderByState("OnHold");
//        OrderService.getOrderService().executeSendInOrder(orders.get(0).getOrderId().toString());
        
//        List<Item> list = new ArrayList<>();
//        list.add(new Item(0L, 1L, 12));
//        list.add(new Item(0L, 1L, 12));
//        Order order = new Order(0L, 1L, "12/21/20", list, "OnHold");
//        OrderService.getOrderService().postOrder(order);
        GUIClientMenu instance = new GUIClientMenu();
        instance.setVisible(true);
    }
}
