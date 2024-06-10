package co.unicauca.microservice.apirest.controller;

import co.unicauca.microservice.apirest.access.microservice.iMicroserviceProduct;
import co.unicauca.microservice.apirest.domain.entity.Item;
import co.unicauca.microservice.apirest.domain.entity.Order;
import co.unicauca.microservice.apirest.domain.service.iItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Items")
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    private iItemService itemService;
    @Autowired
    private iMicroserviceProduct MicroserviceProduct;

    @PostMapping("/post")
    public ResponseEntity<String> posItem(@RequestBody Item item) {
//        item.setProduct(MicroserviceProduct.getProduct(String.valueOf(item.getProduct().getProductId())));
        if (MicroserviceProduct.getProduct(String.valueOf(item.getProductId())) == null)
        {
            return ResponseEntity.ok("The item can't be created because the product correspondent doesn't exist");
        }
        return ResponseEntity.ok(itemService.postItem(item));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(itemService.getItems());
    }
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Item> getOrder(@PathVariable Long id)
    {
        return ResponseEntity.ok(itemService.getItem(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id)
    {
        return ResponseEntity.ok(itemService.deleteItem(id));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putItem(@RequestBody Item item, @PathVariable Long id)
    {
        return ResponseEntity.ok(itemService.putItem(item, id));
    }
}
